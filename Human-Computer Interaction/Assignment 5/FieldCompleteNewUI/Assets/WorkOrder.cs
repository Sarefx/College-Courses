using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class WorkOrder
{
    public List<Job> jobs;
    public int id;
    public string status;
    public string channel;
    public string street, city, state, zipcode;
    public string firstName, lastName, company, phone, altphone;
    public string date, time, duration;

    public static int globalId = 0;

    public WorkOrder(Job job)
    {
        jobs = new List<Job>();
        
        id = globalId + 1;
        globalId = id;
        status = "In progress";
        channel = job.channel;
        street = job.street;
        city = job.city;
        state = job.state;
        zipcode = job.zipcode;
        firstName = job.firstName;
        lastName = job.lastName;
        company = job.company;
        phone = job.phone;
        altphone = job.altphone;
        date = job.date;
        time = job.time;
        duration = job.duration;


        job.workOrderParent = this;

        jobs.Add(job);
    }
    public void AddNewJob(Job job)
    {
        job.workOrderParent = this;
        jobs.Add(job);
    }


}
