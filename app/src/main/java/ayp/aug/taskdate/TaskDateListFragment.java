package ayp.aug.taskdate;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nutdanai on 8/23/2016.
 */
public class TaskDateListFragment extends Fragment {
    RecyclerView mRecyclerView;
    List<String> list1;
    int number;
    private static final String POSSINTION = "POSSINTION";
     private static final String TAG = "TaskDateListFragment";




    public static TaskDateListFragment newInstance(int count) {
        Bundle args = new Bundle();
        args.putInt(POSSINTION,count);
        Log.d(TAG," Position FragmentList : "+ count);
        TaskDateListFragment fragment = new TaskDateListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null) {
            number = getArguments().getInt(POSSINTION);
            Log.d(TAG,"Number is " + number);
        }else {
            number = 1;
            Log.d(TAG,"Else : Number is  " + number);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v =LayoutInflater.from(getActivity()).inflate(R.layout.task_list_fragment,container,false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.fragment_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        createList(number);
        mRecyclerView.setAdapter(new taskAdapter(list1));
        return v;
    }

    public void createList(int i){
        if(list1 == null){
            list1 = new ArrayList<>();
        }

        if(i == 0) {
            list1.add("1");
            list1.add("8");
            list1.add("15");
            list1.add("21");
            list1.add("29");
            list1.add("36");
            list1.add("43");
            list1.add("50");
            list1.add("57");
            list1.add("63");
        }else{
            list1.add("3");
            list1.add("10");
            list1.add("17");
            list1.add("24");
            list1.add("31");
            list1.add("39");
            list1.add("46");
            list1.add("53");
            list1.add("60");
            list1.add("67");
        }
    }
    class taskHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        public taskHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.txt_number_date);
        }

        @TargetApi(Build.VERSION_CODES.N)
        public void bind(String date){
//            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE");
            mTextView.setText(date);
        }
    }

    class taskAdapter extends RecyclerView.Adapter<taskHolder>{
        List<String> dateList;

        public taskAdapter(List<String> dateList) {
            this.dateList=dateList;
        }

        @Override
        public taskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v =LayoutInflater.from(getActivity()).inflate(R.layout.task_date_item,parent,false);
            return new taskHolder(v);
        }

        @Override
        public void onBindViewHolder(taskHolder holder, int position) {
            holder.bind(dateList.get(position));
        }

        @Override
        public int getItemCount() {
            return dateList.size();
        }
    }
}
