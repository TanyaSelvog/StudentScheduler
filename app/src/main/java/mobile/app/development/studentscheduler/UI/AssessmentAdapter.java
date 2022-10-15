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

import mobile.app.development.studentscheduler.Entity.Assessment;
import mobile.app.development.studentscheduler.Entity.Course;
import mobile.app.development.studentscheduler.R;

public class AssessmentAdapter  extends RecyclerView.Adapter<AssessmentAdapter.AssessmentViewHolder>{
    class AssessmentViewHolder extends RecyclerView.ViewHolder{

    private final TextView assessmentItemView;
    private AssessmentViewHolder(View itemView){
    super(itemView);
    assessmentItemView =itemView.findViewById(R.id.assessmentListItem);
    itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position=getAdapterPosition();
            final Assessment currentAssessment = mAssessment.get(position);
            Intent intent = new Intent(contextAssessment,AssessmentDetail.class);
            intent.putExtra("assessmentName", currentAssessment.getAssessmentName());
            intent.putExtra("assessmentStart", currentAssessment.getStartAssessment());
            intent.putExtra("assessmentDate", currentAssessment.getAssessmentDate());
            intent.putExtra("assessmentID", currentAssessment.getAssessmentID());
            intent.putExtra("courseID", currentAssessment.getCourseID());
            intent.putExtra("assessmentType", currentAssessment.getAssessmentType());
            contextAssessment.startActivity(intent);

        }
    });
    }
    }
    private List<Assessment> mAssessment;
    private final Context contextAssessment;
    private final LayoutInflater mInflaterAssessment;
    public AssessmentAdapter(Context contextAssessment) {
        mInflaterAssessment= LayoutInflater.from(contextAssessment);
        this.contextAssessment = contextAssessment;
    }
    @NonNull
    @Override
    public AssessmentAdapter.AssessmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflaterAssessment.inflate(R.layout.assessment_list_item,parent,false);
        return new AssessmentViewHolder(itemView);
    }
        @Override
        public void onBindViewHolder(@NonNull AssessmentAdapter.AssessmentViewHolder holder, int position) {
            if (mAssessment != null) {
                Assessment current = mAssessment.get(position);
                //NEED TO CHNAGE THIS
                String name = current.getAssessmentName();
                String tName = current.getStartAssessment();
                int id = current.getAssessmentID();
                holder.assessmentItemView.setText(name);
            } else {
                holder.assessmentItemView.setText("No assessment name");
            }
        }

    public void setAssessments(List<Assessment> assessments){
        mAssessment=assessments;
        notifyDataSetChanged();
    }

        @Override
        public int getItemCount() {
            if(mAssessment != null)
                return mAssessment.size();
            else return 0;
        }
    }



