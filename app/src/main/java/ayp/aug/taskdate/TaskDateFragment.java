package ayp.aug.taskdate;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Nutdanai on 8/23/2016.
 */
public class TaskDateFragment extends Fragment {
    TextView textView;
     private static final String TAG = "TaskDateFragment";



    public static TaskDateFragment newInstance(String s) {
        Bundle args = new Bundle();
        args.putSerializable("test",s);
        TaskDateFragment fragment = new TaskDateFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.task_pager_date_item,container,false);
        String temp = (String) getArguments().getSerializable("test");
        textView =(TextView) v.findViewById(R.id.txt_pager_item);
        textView.setText(temp);
        return v;
    }
}
