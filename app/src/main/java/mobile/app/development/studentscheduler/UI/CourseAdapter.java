package mobile.app.development.studentscheduler.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mobile.app.development.studentscheduler.Entity.Course;
import mobile.app.development.studentscheduler.Entity.Term;
import mobile.app.development.studentscheduler.R;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder>{
    class CourseViewHolder extends RecyclerView.ViewHolder{

    private final TextView courseItemView;
    private CourseViewHolder(View itemView){
        super(itemView);
        courseItemView =itemView.findViewById(R.id.textView3);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=getAdapterPosition();
                final Course current = mCourse.get(position);
                Intent intent = new Intent(context,CourseList.class);
                intent.putExtra("courseName", current.getCourseTitle());

            }
        });
    }
}
    private List<Course> mCourse;
    private final Context context;
    private final LayoutInflater mInflater;
    public CourseAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }
    @NonNull
    @Override
    public CourseAdapter.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.course_list_item,parent,false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.CourseViewHolder holder, int position) {
        if(mCourse!=null){
            Course current = mCourse.get(position);
            String name=current.getCourseTitle();
            holder.courseItemView.setText(name);
        }
        else{
            holder.courseItemView.setText("No course name");
        }

    }
    public void setCourses(List<Course> courses){
        mCourse=courses;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mCourse != null)
            return mCourse.size();
        else return 0;
    }
}
