package mobile.app.development.studentscheduler.UI;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mobile.app.development.studentscheduler.Entity.Assessment;
import mobile.app.development.studentscheduler.Entity.Course;
import mobile.app.development.studentscheduler.R;

public class AssessmentAdapter  extends RecyclerView.Adapter<AssessmentAdapter.AssessmentViewHolder>{
    class AssessmentViewHolder extends RecyclerView.ViewHolder{

    private final TextView assessmentItemView;
    private AssessmentViewHolder(View itemView){
    super(itemView);
    assessmentItemView =itemView.findViewById(R.id.textView4);
    itemView.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onBindViewHolder(@NonNull AssessmentAdapter.AssessmentViewHolder holder, int position) {
            if(mAssessments!=null){
                Course current = mAssessments.get(position);
              //NEED TO CHNAGE THIS
                //  String name=current.getCourseTitle();
                holder.assessmentItemView.setText(name);
            }
            else{
                holder.assessmentItemView.setText("No course name");
            }


    public void setAssessments(List<Assessment> assessments){
        mAssessments=assessments;
        notifyDataSetChanged();
    }

        @Override
        public int getItemCount() {
            if(mAssessments != null)
                return mAssessments.size();
            else return 0;
        }
    }
}


