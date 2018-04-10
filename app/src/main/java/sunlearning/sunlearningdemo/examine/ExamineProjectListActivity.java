package sunlearning.sunlearningdemo.examine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.examine.adapter.ProjectGridViewApdater;
import sunlearning.sunlearningdemo.model.ExamineProjectEntity;
import sunlearning.sunlearningdemo.utils.init.InitDataUtil;

public class ExamineProjectListActivity extends AppCompatActivity {
    private LinearLayout topSelector;
    private TextView topTitle;
    private TextView topTitleFlag;
    private TextView topTitleFlagInvert;
    private GridView projectGridView;
    private List<ExamineProjectEntity> projectList;
    private ExamineProjectEntity curProject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examine_project_list);
        projectGridView = (GridView) findViewById(R.id.examine_project_grid_view);
        topSelector= (LinearLayout) findViewById(R.id.examine_top_selector);
        topTitle = (TextView) findViewById(R.id.top_examine_title);
        topTitleFlag= (TextView) findViewById(R.id.top_examine_flag);
        topTitleFlagInvert= (TextView) findViewById(R.id.top_examine_flag_invert);

        initData();
        initWidget();
        initEvent();
    }

    private void initEvent() {
        topSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnPreviousActivity(0,curProject);
            }
        });

        projectGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProjectGridViewApdater.ViewHolder viewHolder = (ProjectGridViewApdater.ViewHolder) view.getTag();
                curProject = new ExamineProjectEntity();
                curProject.setId(Integer.valueOf(viewHolder.projectId.getText().toString()));
                curProject.setName(viewHolder.projectName.getText().toString());
                returnPreviousActivity(0,curProject);
            }
        });
    }

    private void initWidget() {
        resetTopMenu(curProject);
        initProjectGridView();
    }

    private void resetTopMenu(ExamineProjectEntity curProject) {
        if(curProject!=null){
            topTitle.setText(curProject.getName());
            topTitleFlagInvert.setVisibility(View.GONE);
            topTitleFlag.setVisibility(View.VISIBLE);
        }
    }

    private void initProjectGridView() {
        projectGridView.setAdapter(new ProjectGridViewApdater(getApplicationContext(),projectList));
        projectGridView.setNumColumns(3);
    }

    private void initData() {
        Intent intent = getIntent();
        projectList= InitDataUtil.getExamineProjectsData();
        curProject= (ExamineProjectEntity) intent.getSerializableExtra("curProject");
    }

    /**
     * 返回调用此activity的上一个activiy
     */
    private void returnPreviousActivity(int resultCode,Serializable curProject){
        //获取此activity创建时的intent
        Intent intent = getIntent();
        intent.putExtra("curProject",curProject);
        //设置结果码
        setResult(resultCode,intent);
        //释放当前activity的资源
        finish();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_BACK:returnPreviousActivity(0,curProject);break;
        }
        return true;
    }
}
