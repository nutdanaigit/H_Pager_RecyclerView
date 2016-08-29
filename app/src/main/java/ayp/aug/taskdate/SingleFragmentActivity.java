package ayp.aug.taskdate;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SingleFragmentActivity extends AppCompatActivity {
    private static final String TAG = "SingleFragmentActivity";
    ViewPager _viewPager;
    Fragment fragmentTwo;
    FragmentManager fm;

    @LayoutRes
    public int getLayoutResId() {
        return R.layout.activity_single_fragment;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        fm = getSupportFragmentManager();
        fragmentTwo = fm.findFragmentById(R.id.fragment_container);

        _viewPager = (ViewPager) findViewById(R.id.pager_view);
        final List<String> date;
        date = new ArrayList<>();
        date.add("Monday");
        date.add("Tuesday");


        _viewPager.setAdapter(new FragmentPagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Fragment f = TaskDateFragment.newInstance(date.get(position));
                Log.d(TAG, "Activity : Position" + position);
                return f;
            }

            @Override
            public int getCount() {
                return date.size();
            }
        });

        _viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                fragmentTwo = TaskDateListFragment.newInstance(position);
                fm.beginTransaction().replace(R.id.fragment_container,fragmentTwo).commit();
            }
        });


        if (fragmentTwo == null) {
            fragmentTwo = new TaskDateListFragment();
            fm.beginTransaction().replace(R.id.fragment_container, fragmentTwo).commit();
        }


    }


}
