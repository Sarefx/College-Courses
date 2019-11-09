using System.Collections;
using System.Collections.Generic;

public class Job
{
    public string phone, street, zipcode, state, city;
    public string altphone, company, firstName, lastName, jobDescription;
    public string channel, branch, jobType, date, time, duration, contractor;
    public string nte;
    public int id;
    public string status;
    public WorkOrder workOrderParent;

    public static int globalId;

    public Job(string phone, string street, string zipcode, string state, string city, string channel, string branch, string jobType, string date, string time, string duration, string contractor)
    {
        this.phone = phone;
        this.street = street;
        this.zipcode = zipcode;
        this.state = state;
        this.city = city;
        this.channel = channel;
        this.branch = branch;
        this.jobType = jobType;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.contractor = contractor;
        this.id = globalId + 1;
        globalId = this.id;

        status = "In progress";
    }
    public void Complete()
    {
        status = "Completed";
    }
    public void Canceled()
    {
        status = "Canceled";
    }
	
}
