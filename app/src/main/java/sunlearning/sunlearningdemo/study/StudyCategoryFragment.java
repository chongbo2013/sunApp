package sunlearning.sunlearningdemo.study;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import sunlearning.common.listener.SmartRefreshLayoutCallbackListener;
import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.model.CourseEntity;
import sunlearning.sunlearningdemo.study.adapter.CourseAdapter;
import sunlearning.sunlearningdemo.utils.init.InitDataUtil;


public class StudyCategoryFragment extends Fragment {

    private ListView courseListView;
    private SmartRefreshLayout refreshLayout;
    private CourseAdapter courseAdapter;
    List<CourseEntity> courseList;

    public StudyCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_study_category, container, false);
        courseListView = view.findViewById(R.id.study_category_lv);
        refreshLayout = view.findViewById(R.id.refreshLayout);
        refreshLayout.setEnableScrollContentWhenRefreshed(true);
        refreshLayout.setRefreshHeader(new ClassicsHeader(getContext()));


        initData();
        initEvent();
        initWidegt();
        return view;

    }

    private void initData() {
        courseList = InitDataUtil.getCoursesInitData();
    }

    private void initWidegt() {
        initSmartRefreshLayout();
        initListView();

    }

    private void initListView() {
        courseAdapter=new CourseAdapter(courseList, getContext());
        courseListView.setAdapter(courseAdapter);
    }

    private void initSmartRefreshLayout() {
        refreshLayout.setCallbackListener(new SmartRefreshLayoutCallbackListener() {
            @Override
            public void preRefresh() {
                Toast.makeText(getContext(), "捕获刷新前的事件", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterFinish() {

            }
        });
    }

    private void initEvent() {
        courseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CourseAdapter.ViewHolder viewHolder = (CourseAdapter.ViewHolder) view.getTag();
                String itemId = viewHolder.courseId.getText().toString();
                String itemName = viewHolder.courseName.getText().toString();

                String text = "第" + (position + 1) + "项item被点击，名称：" + itemName + ",id:" + itemId;
                Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();


            }
        });

        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(final RefreshLayout refreshlayout) {
                new Handler().post(new Runnable() {
                    @Override
                    public void run() {
                        List<CourseEntity> courseEntities = courseAdapter.getmData();
                        courseEntities.add(new CourseEntity(9, "新经理容易陷入的4个误区9", "职场中基层管理类系列课程是围绕企业", R.drawable.icon_course, new Timestamp(new Date().getTime()), 20));
                        courseEntities.add(new CourseEntity(10, "新经理容易陷入的4个误区10", "职场中基层管理类系列课程是围绕企业", R.drawable.icon_course, new Timestamp(new Date().getTime()), 20));
                        courseEntities.add(new CourseEntity(11, "新经理容易陷入的4个误区11", "职场中基层管理类系列课程是围绕企业", R.drawable.icon_course, new Timestamp(new Date().getTime()), 20));
                        courseAdapter.notifyDataSetChanged();
                        refreshlayout.finishRefresh(1000, true);//传入false表示刷新失败
                    }
                });

            }
        });

    }


}
