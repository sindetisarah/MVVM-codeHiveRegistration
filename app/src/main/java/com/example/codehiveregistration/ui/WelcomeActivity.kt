package com.example.codehiveregistration.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codehiveregistration.R
import com.example.codehiveregistration.models.Course
import com.example.codehiveregistration.models.CoursesAdapter

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        var rvCourse=findViewById<RecyclerView>(R.id.rvCourses)
        //adapater expect a list of courses which we will need to create
        var courseList= listOf(
            Course("Mobile Development","AndroidStudio","Mobile Develops","JohnOwuor"),
            Course("FrontEnd","JavaScript","React and Vue Js","Purity Maina"),
            Course("BackendDevelopment","Python","Learning on Algorithms","John Mwai"),
            Course("PD","PD","Professional Courtesy","Rodgers Awoko"),
            Course("123p","Design","Learning the Design EWorld","Eric")

        )
        var coursesAdapter= CoursesAdapter(courseList)
        rvCourse.adapter=coursesAdapter
        rvCourse.layoutManager= LinearLayoutManager(baseContext)
    }
}