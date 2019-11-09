using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class User
{
    public string name;
    public List<string> jobTypes = new List<string>();

    public User(string name)
    {
        this.name = name;
    }
}
