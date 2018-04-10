package sunlearning.sunlearningdemo.study;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.model.CourseProjectEntity;
import sunlearning.sunlearningdemo.study.adapter.CourseProjectListAdapter;
import sunlearning.sunlearningdemo.utils.init.InitDataUtil;


public class CourseProjectListActivity extends Activity {
    private GridView projectGridView;
    private TextView projectSelectorBtn;
    private List<CourseProjectEntity> projectList;
    private CourseProjectEntity curProject;
    private TextView topTitleFlag;
    private TextView topTitleFlagInvert;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_course_project_list);
        projectSelectorBtn = findViewById(R.id.study_top_menu_project_selector);
        projectGridView = findViewById(R.id.project_grid_view);
        topTitleFlag=findViewById(R.id.top_examine_flag);
        topTitleFlagInvert=findViewById(R.id.top_examine_flag_invert);

        initData();
        initWidget();
        initEvent();

    }

    private void initWidget() {
        resetTopMenu(curProject);
        initGridView();
    }

    private void initGridView() {
        projectGridView.setAdapter(new CourseProjectListAdapter(projectList, getApplicationContext()));
    }

    private void initData() {
        if (getIntent() != null) {
            curProject = (CourseProjectEntity) getIntent().getSerializableExtra("curProject");
        }
        projectList = InitDataUtil.getCourseProjectsData();
    }


    private void resetTopMenu(CourseProjectEntity curProject) {
        if (curProject != null) {
            projectSelectorBtn.setText(curProject.getName());
            topTitleFlagInvert.setVisibility(View.GONE);
            topTitleFlag.setVisibility(View.VISIBLE);
        } else {
            projectSelectorBtn.setText("暂无项目");
        }
    }

    private void initEvent() {
        projectSelectorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回上一个结果页
                returnPreviousActivity(1, curProject);
            }
        });

        projectGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CourseProjectListAdapter.ViewHolder viewHolder = (CourseProjectListAdapter.ViewHolder) view.getTag();
                int projectId = Integer.valueOf(viewHolder.projectId.getText().toString());
                String projectName = viewHolder.projectName.getText().toString();
                String text = "第" + id + "项被点击，项目id：" + projectId + ",项目名称：" + projectName;
                //显示Toast
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                //修改当前顶部菜单中当前项目的名称
                returnPreviousActivity(0, curProject);
            }
        });
    }

    /**
     * 返回调用此activity的上一个activiy
     */
    private void returnPreviousActivity(int resultCode, Serializable curProject) {
        //获取此activity创建时的intent
        Intent intent = getIntent();
        intent.putExtra("curProject", curProject);
        //设置结果码
        setResult(resultCode, intent);
        //释放当前activity的资源
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                returnPreviousActivity(0, curProject);
                break;
        }
        return true;
    }
}
