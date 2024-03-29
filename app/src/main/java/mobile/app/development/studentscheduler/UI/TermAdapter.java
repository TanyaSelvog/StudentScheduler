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

import mobile.app.development.studentscheduler.Entity.Term;
import mobile.app.development.studentscheduler.R;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder>{
    class TermViewHolder extends RecyclerView.ViewHolder{
        private final TextView termItemView;
        private TermViewHolder(View itemView){
            super(itemView);
            termItemView =itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    final Term current = mTerms.get(position);
                    Intent intent = new Intent(context,TermDetail.class);
                    intent.putExtra("termName", current.getTermName());
                    intent.putExtra("termID", current.getTermID());
                    intent.putExtra("startTermDate", current.getStartTermDate());
                    intent.putExtra("endTermDate", current.getEndTermDate());
                    context.startActivity(intent);

                }
            });
        }
    }
    private List<Term> mTerms;
    private final Context context;
    private final LayoutInflater mInflater;
    public TermAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }
    @NonNull
    @Override
    public TermAdapter.TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.term_list_item,parent,false);
        return new TermViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TermAdapter.TermViewHolder holder, int position) {
        if(mTerms!=null){
            Term current = mTerms.get(position);
            String name=current.getTermName();
            String endDate=current.getEndTermDate();
            String start= current.getStartTermDate();
            holder.termItemView.setText("Term: " + name +  " Start: " + start + " End: " + endDate);
        }
        else{
            holder.termItemView.setText("No term name");
        }

    }
    public void setTerms(List<Term> terms){
        mTerms=terms;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mTerms != null)
        return mTerms.size();
    else return 0;
}}
