using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.EventSystems;
using UnityEngine.UI;

public class ScreenController : MonoBehaviour
{
    public GameObject Dashboard_Panel, NewJob_Panel, Channels_Panel, Users_Panel, Reports_Panel, Settings_Panel;
    public GameObject CompanyOptions_Panel;
    public Text SelectedPanel_Text;
    public GameObject Dashboard_Button, NewJob_Button, Company_Button, Reports_Button, Settings_Button;

    // Dashboard Panel
    public GameObject JobsList_Panel, WorkOrder_Panel, Job_Panel;

    // Work Order Panel
    public Dropdown WorkOrderChannel_Dropdown, WorkOrderStatus_Dropdown;
    public GameObject WOJobsList_Panel;
    public Text WOAddress_Text, WOID_Text, WOClient_Text, WODate_Text;

    // Job Panel
    public Dropdown JobStatus_Dropdown;
    public Text JobDescription_Text;

    // New Job Panel
    public InputField Phone_InputField, Street_InputField, ZipCode_InputField, State_InputField, City_InputField;
    public InputField AltPhone_InputField, Company_InputField, FirstName_InputField, LastName_InputField, JobDescription_InputField;
    public Dropdown Channel_Dropdown, Branch_Dropdown, JobType_Dropdown, Time_Dropdown, Duration_Dropdown, Contractor_Dropdown;
    public InputField NTE_InputField;
    public GameObject Calendar_Panel;
    public Dropdown Day_Dropdown, Month_Dropdown, Year_Dropdown;


    // Channels Panel
    public GameObject ChannelsList_Panel;
    public InputField Channel_InputField;
    public Text ChannelName_Text;

    // Users Panel
    public GameObject UsersList_Panel;
    public InputField User_InputField;
    public Text UserName_Text;
    public GameObject UserJobTypes_Panel;
    public Dropdown UserJobTypes_Dropdown;


    // Code data
    private List<WorkOrder> workOrders = new List<WorkOrder>();
    private List<Job> jobs = new List<Job>();
    private List<string> channels = new List<string>();
    private List<User> users = new List<User>();
    private List<string> userNames = new List<string>();
    private List<string> branches = new List<string>();
    private List<string> jobTypes = new List<string>();
    private List<string> times = new List<string>();
    private List<string> durations = new List<string>();
    private List<string> statuses = new List<string>();
    private List<string> days = new List<string>();
    private List<string> months = new List<string>();
    private List<string> years = new List<string>();


    private string selectedChannel;
    private User selectedUser;
    private WorkOrder selectedWorkOrder;
    private Job selectedJob;
    

    // Use this for initialization
    void Start()
    {
        WorkOrder_Panel.SetActive(false);
        Job_Panel.SetActive(false);
        CompanyOptions_Panel.SetActive(false);
        Calendar_Panel.SetActive(false);
        SwitchPanel(1);

        

        branches.Add("Atlanta");
        branches.Add("Miami");
        branches.Add("Chicago");
        branches.Add("Tampa");
        branches.Add("Orlando");

        Branch_Dropdown.ClearOptions();
        Branch_Dropdown.AddOptions(branches);

        jobTypes.Add("HVAC");
        jobTypes.Add("Plumbing");
        jobTypes.Add("Handyman");
        jobTypes.Add("Electrical");
        jobTypes.Add("Gutters");

        JobType_Dropdown.ClearOptions();
        JobType_Dropdown.AddOptions(jobTypes);

        times.Add("1:00 AM");
        times.Add("2:00 AM");
        times.Add("3:00 AM");
        times.Add("4:00 AM");
        times.Add("5:00 AM");
        times.Add("6:00 AM");
        times.Add("7:00 AM");
        times.Add("8:00 AM");
        times.Add("9:00 AM");
        times.Add("10:00 AM");
        times.Add("11:00 AM");
        times.Add("12:00 PM");
        times.Add("1:00 PM");
        times.Add("2:00 PM");
        times.Add("3:00 PM");
        times.Add("4:00 PM");
        times.Add("5:00 PM");
        times.Add("5:00 PM");
        times.Add("6:00 PM");
        times.Add("7:00 PM");
        times.Add("8:00 PM");
        times.Add("9:00 PM");
        times.Add("10:00 PM");
        times.Add("11:00 PM");
        times.Add("12:00 AM");

        Time_Dropdown.ClearOptions();
        Time_Dropdown.AddOptions(times);

        durations.Add("1 hour");
        durations.Add("2 hours");
        durations.Add("3 hours");
        durations.Add("4 hours");
        durations.Add("5 hours");
        durations.Add("6 hours");
        durations.Add("7 hours");
        durations.Add("8 hours");
        durations.Add("9 hours");
        durations.Add("10 hours");

        Duration_Dropdown.ClearOptions();
        Duration_Dropdown.AddOptions(durations);


        for (int d = 1; d <= 31; d++)
        {
            days.Add(d + "");
        }
        Day_Dropdown.ClearOptions();
        Day_Dropdown.AddOptions(days);

        for (int m = 1; m <= 12; m++)
        {
            months.Add(m + "");
        }
        Month_Dropdown.ClearOptions();
        Month_Dropdown.AddOptions(months);
        /*
        for (int y = 2018; y <= 10; y++)
        {
            years.Add(y + "");
        }
        */
        years.Add("2018");
        years.Add("2019");
        years.Add("2020");
        years.Add("2021");
        years.Add("2022");
        Year_Dropdown.ClearOptions();
        Year_Dropdown.AddOptions(years);



        // Test Values
        channels.Add("CAH");
        channels.Add("IH");
        channels.Add("Altisource");
        channels.Add("Wells Wargo");

        users.Add(new User("Jonny Bravo"));
        users.Add(new User("Tony Stark"));
        users.Add(new User("Nikita Koba"));

        workOrders.Add(new WorkOrder(new Job("7705333340", "1234 Iron Man St", "30208", "FL", "Miami", "IH", "Miami", "HVAC", "5/21/2018", "2:00 PM", "2 hours", "Tony Stark")));
        workOrders.Add(new WorkOrder(new Job("7705333341", "4500 Gains St", "30509", "GA", "Atlanta", "CAH", "Atlanta", "HVAC", "5/25/2018", "2:00 PM", "6 hours", "Jonny Bravo")));



        statuses.Add("In progress");
        statuses.Add("Completed");
        statuses.Add("Canceled");

        selectedUser = users[0];

        WorkOrderStatus_Dropdown.ClearOptions();
        WorkOrderStatus_Dropdown.AddOptions(statuses);

        JobStatus_Dropdown.ClearOptions();
        JobStatus_Dropdown.AddOptions(statuses);

        UpdateScreen();
    }

    // Update is called once per frame
    void Update()
    {
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void UpdateScreen()
    {
        userNames.Clear();
        foreach (User user in users)
        {
            userNames.Add(user.name);
        }



        if (Dashboard_Panel.activeSelf)
        {
            SelectedPanel_Text.text = "Dashboard";


            jobs.Clear();

            foreach (WorkOrder workOrder in workOrders)
            {
                foreach (Job job in workOrder.jobs)
                {
                    jobs.Add(job);
                }
            }

            //Debug.Log("Count of jobs is " + jobs.Count);
            Text jobLineText;
            for (int a = 0; a < 4; a++)
            {
                //Debug.Log("A is " + a);
                jobLineText = JobsList_Panel.transform.Find("Job" + (a + 1) + "_Text").GetComponent<Text>();

                if (jobs.Count > a && jobs[a] != null)
                {
                    jobLineText.text = " ID: " + jobs[a].id + " Address: " +jobs[a].street + ", " + jobs[a].city + ", " + jobs[a].state + ", " + jobs[a].zipcode + " ";
                    if (jobs[a].status == "In progress")
                    {
                        jobLineText.color = Color.yellow;
                    }
                    else if (jobs[a].status == "Completed")
                    {
                        jobLineText.color = Color.green;
                    }
                    else if (jobs[a].status == "Canceled")
                    {
                        jobLineText.color = Color.red;
                    }



                }
                else
                {
                    jobLineText.text = "";
                }
            }


        }
        
        else if (Job_Panel.activeSelf)
        {

        }
        else if (NewJob_Panel.activeSelf)
        {
            SelectedPanel_Text.text = "New Job";

            Channel_Dropdown.ClearOptions();
            Channel_Dropdown.AddOptions(channels);

            Contractor_Dropdown.ClearOptions();
            Contractor_Dropdown.AddOptions(userNames);

        }
        else if (Channels_Panel.activeSelf)
        {
            SelectedPanel_Text.text = "Channels";

            /*
            GameObject channelsList_Panel;
            channelsList_Panel = Channels_Panel.transform.Find("ChannelsList_Panel").gameObject;

            GameObject channelLine_Text = new GameObject();
            channelLine_Text.transform.parent = channelsList_Panel.transform;
            channelLine_Text.transform.position = channelsList_Panel.transform.position;
            channelLine_Text.transform.localScale = channelsList_Panel.transform.localScale;
            

            //channelLine_Text.transform.localPosition = channelsList_Panel.transform.position;
            channelLine_Text.AddComponent<Text>();
            channelLine_Text.GetComponent<Text>().text = "This is a test";
            channelLine_Text.GetComponent<Text>().resizeTextForBestFit = true;
            channelLine_Text.GetComponent<Text>().color = Color.black;
            channelLine_Text.GetComponent<Text>().font = Font.CreateDynamicFontFromOSFont("Arial", 14);
            channelLine_Text.SetActive(true);
            */
            Text channelLineText;

            for (int a = 0; a < 6; a++)
            {
                channelLineText = ChannelsList_Panel.transform.Find("Channel" + (a + 1) + "_Text").GetComponent<Text>();

                if (channels.Count > a && channels[a] != null)
                {
                    channelLineText.text = channels[a];
                }
                else
                {
                    channelLineText.text = "";
                }

            }
            ChannelName_Text.text = "Channel: " + selectedChannel;

        }
        else if (Users_Panel.activeSelf)
        {
            SelectedPanel_Text.text = "Users";
            Text userLineText;

            //Debug.Log("THe count of the string is " + users.Count);
            for (int a = 0; a < 6; a++)
            {
                //Debug.Log("A is " + a);
                userLineText = UsersList_Panel.transform.Find("User" + (a + 1) + "_Text").GetComponent<Text>();

                if (userNames.Count > a && userNames[a] != null)
                {
                    userLineText.text = userNames[a];
                }
                else
                {
                    userLineText.text = "";
                }

            }

            UserJobTypes_Dropdown.ClearOptions();
            UserJobTypes_Dropdown.AddOptions(jobTypes);

            Text jobTypeLineText;
            for (int a = 0; a < 4; a++)
            {
                jobTypeLineText = UserJobTypes_Panel.transform.Find("UserJobType" + (a + 1) + "_Text").GetComponent<Text>();

                if (selectedUser.jobTypes.Count > a && selectedUser.jobTypes[a] != null)
                {
                    jobTypeLineText.text = selectedUser.jobTypes[a];
                }
                else
                {
                    jobTypeLineText.text = "";
                }

            }

            UserName_Text.text = "User: " + selectedUser.name;
        }
        else if (Reports_Panel.activeSelf)
        {
            SelectedPanel_Text.text = "Reports";
        }
        else if (Settings_Panel.activeSelf)
        {
            SelectedPanel_Text.text = "Settings";
        }

        if (WorkOrder_Panel.activeSelf)
        {
            WorkOrderChannel_Dropdown.ClearOptions();
            WorkOrderChannel_Dropdown.AddOptions(channels);
            WorkOrderChannel_Dropdown.value = (channels.IndexOf(selectedWorkOrder.channel));
            WorkOrderStatus_Dropdown.value = (statuses.IndexOf(selectedWorkOrder.status));
            WOAddress_Text.text = "Address: " + selectedWorkOrder.street + ", " + selectedWorkOrder.city + ", " + selectedWorkOrder.state + ", " + selectedWorkOrder.zipcode + " ";
            WOID_Text.text = "Work Order ID: " + selectedWorkOrder.id + " ";
            WOClient_Text.text = "Client: " + selectedWorkOrder.firstName + " " + selectedWorkOrder.lastName + " Phone: " + selectedWorkOrder.phone + " ";
            WODate_Text.text = "Date: " + selectedWorkOrder.date + " Time: " + selectedWorkOrder.time + " Duration: " + selectedWorkOrder.duration + " ";

            Text jobLineText;

            for (int a = 0; a < 4; a++)
            {
                jobLineText = WOJobsList_Panel.transform.Find("WOJob" + (a + 1) + "_Text").GetComponent<Text>();

                List<Job> jobsWO = selectedWorkOrder.jobs;

                if (jobsWO.Count > a && jobsWO[a] != null)
                {
                    jobLineText.text = " ID: " + jobsWO[a].id + " ";
                    if (jobsWO[a].status == "In progress")
                    {
                        jobLineText.color = Color.yellow;
                    }
                    else if (jobsWO[a].status == "Completed")
                    {
                        jobLineText.color = Color.green;
                    }
                    else if (jobsWO[a].status == "Canceled")
                    {
                        jobLineText.color = Color.red;
                    }
                }
                else
                {
                    jobLineText.text = "";
                }
            }
            



        }

        if (Job_Panel.activeSelf)
        {
            JobStatus_Dropdown.value = (statuses.IndexOf(selectedJob.status));
            JobDescription_Text.text = "Job Description: " + selectedJob.jobDescription + " ";



        }



    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // General Options Start
    public void SwitchPanel(int choice)
    {
        Dashboard_Panel.SetActive(false);
        NewJob_Panel.SetActive(false);
        Reports_Panel.SetActive(false);
        Channels_Panel.SetActive(false);
        Users_Panel.SetActive(false);
        Settings_Panel.SetActive(false);

  

        //.GetComponent<Image>().color = blueColor;
        //NewJob_Button.GetComponent<Image>().color = blueColor;
        //Reports_Button.GetComponent<Image>().color = blueColor;
        //Company_Button.GetComponent<Image>().color = blueColor;
        //Settings_Button.GetComponent<Image>().color = blueColor;
 

        switch (choice)
        {
            case 1:
                Dashboard_Panel.SetActive(true);
                //Dashboard_Button.GetComponent<Image>().color = Color.green;
                break;
            case 2:
                NewJob_Panel.SetActive(true);
                //NewJob_Button.GetComponent<Image>().color = Color.green;
                break;
            case 3:
                Reports_Panel.SetActive(true);
                //Reports_Button.GetComponent<Image>().color = Color.green;
                break;
            case 4:
                Channels_Panel.SetActive(true);
                //Company_Button.GetComponent<Image>().color = Color.green;
                break;
            case 5:
                Users_Panel.SetActive(true);
                //Company_Button.GetComponent<Image>().color = Color.green;
                break;
            case 6:
                Settings_Panel.SetActive(true);
                //Settings_Button.GetComponent<Image>().color = Color.green;
                break;
        }
        UpdateScreen();
    }
    public void OpenCompanyOptions(BaseEventData baseEventData)
    {
        CompanyOptions_Panel.GetComponent<RectTransform>().SetAsLastSibling();
        CompanyOptions_Panel.SetActive(true);
    }
    public void CloseCompanyOptions(BaseEventData baseEventData)
    {
        CompanyOptions_Panel.SetActive(false);
    }
    // General Options End

    // Dashboard Panel Start 
    public void OpenSelectedJob(int choice)
    {
        Debug.Log("Job " + choice + " was selected.");
        selectedWorkOrder = jobs[choice - 1].workOrderParent;

        WorkOrder_Panel.SetActive(true);

        UpdateScreen();
    }
    // Dashboard Panel End 

    // Work Order Panel Start
    public void UpdateSelectedWorkOrder()
    {
        selectedWorkOrder.channel = channels[WorkOrderChannel_Dropdown.value];
        selectedWorkOrder.status = statuses[WorkOrderStatus_Dropdown.value];

        UpdateScreen();
    }
    public void CloseWO()
    {
        WorkOrder_Panel.SetActive(false);

        UpdateScreen();
    }
    public void OpenSelectedWOJob(int choice)
    {
        selectedJob = selectedWorkOrder.jobs[choice - 1];
        Job_Panel.SetActive(true);

        UpdateScreen();
    }
    // Work Order Panel End

    // Job Panel Start
    public void UpdateSelectedJob()
    {
        selectedJob.status = statuses[JobStatus_Dropdown.value];

        UpdateScreen();
    }
    public void CloseJob()
    {
        Job_Panel.SetActive(false);

        UpdateScreen();
    }
    // Job Panel End

    // New Job Panel Start
    public void OpenCalendar()
    {
        Calendar_Panel.SetActive(true);
    }
    public void CloseCalendar()
    {
        Calendar_Panel.SetActive(false);
    }
    public void AddNewJob()
    {
        string phone = Phone_InputField.text;
        string street = Street_InputField.text;
        string zipcode = ZipCode_InputField.text;
        string state = State_InputField.text;
        string city = City_InputField.text;
        string channel = channels[Channel_Dropdown.value];
        string branch = branches[Branch_Dropdown.value];
        string jobType = jobTypes[JobType_Dropdown.value];
        string date = "" + months[Month_Dropdown.value] + "/" + days[Day_Dropdown.value] + "/" + years[Year_Dropdown.value] + "";
        string time = times[Time_Dropdown.value];
        string duration = durations[Duration_Dropdown.value];
        string contractor = userNames[Contractor_Dropdown.value];

        Job tempJob = new Job(phone, street, zipcode, state, city, channel, branch, jobType, date, time, duration, contractor);

        tempJob.jobDescription = JobDescription_InputField.text + "";
        tempJob.firstName = FirstName_InputField.text + "";
        tempJob.lastName = LastName_InputField.text + "";
        tempJob.company = Company_InputField.text + "";
        tempJob.altphone = AltPhone_InputField.text + "";

        tempJob.nte = NTE_InputField.text + "";

        workOrders.Add(new WorkOrder(tempJob));

        UpdateScreen();
    }
    // New Job Panel End

    // Channels Panel Start
    public void AddNewChannel()
    {
        string newChannel = Channel_InputField.text;
        channels.Add(newChannel);

        UpdateScreen();
    }
    public void SelectedChannel(int choice)
    {
        Debug.Log("Channel " + choice + " was selected.");
        selectedChannel = ChannelsList_Panel.transform.Find("Channel" + (choice) + "_Text").GetComponent<Text>().text;

        UpdateScreen();
    }
    public void DeleteSelectedChannel()
    {
        channels.Remove(selectedChannel);
        selectedChannel = "";

        UpdateScreen();
    }
    // Channels Panel End


    // Users Panel Start
    public void AddNewUser()
    {
        string newUserName = User_InputField.text;

        users.Add(new User(newUserName));

        UpdateScreen();
    }
    public void SelectedUser(int choice)
    {
        Debug.Log("User " + choice + " was selected.");
        selectedUser = users[choice - 1];

        UpdateScreen();
    }
    public void DeleteSelectedUser()
    {
        users.Remove(selectedUser);
        UserName_Text.text = "";

        UpdateScreen();
    }
    public void AddSelectedJobType()
    {
        string jobType = jobTypes[UserJobTypes_Dropdown.value];
        selectedUser.jobTypes.Add(jobType);

        UpdateScreen();
    }
    // Users Panel End

}
