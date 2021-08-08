package com.example.codehiveregistration.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.codehiveregistration.R

class CoursesAdapter (var courseList: List<CourseResponse>):RecyclerView.Adapter<CoursesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        //create a view holder create item view use that to create an instance of our view holder
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.course_list_item,parent,false)
        return CoursesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        //reference to current course
        var currentCourse=courseList.get(position)
        //set att to the view displayed.Bind the data to the views
        holder.tvCourseName.text=currentCourse.course_name
        holder.tvDescription.text=currentCourse.description
        holder.tvInstructor.text=currentCourse.instructor
        holder.tvCourseCode.text=currentCourse.course_code


    }

    override fun getItemCount(): Int {
        //How big is the list
        return courseList.size
    }


}
class CoursesViewHolder( itemView: View):RecyclerView.ViewHolder(itemView){
    var tvCourseName=itemView.findViewById<TextView>(R.id.tvCourseName)
    var tvDescription=itemView.findViewById<TextView>(R.id.tvDescription)
    var tvInstructor=itemView.findViewById<TextView>(R.id.tvInstructor)
    var tvCourseCode=itemView.findViewById<TextView>(R.id.tvCourseCode)

}