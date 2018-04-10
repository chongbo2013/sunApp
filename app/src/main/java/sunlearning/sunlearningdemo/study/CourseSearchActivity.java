package sunlearning.sunlearningdemo.study;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.model.CourseEntity;
import sunlearning.sunlearningdemo.study.adapter.CourseAdapter;
import sunlearning.sunlearningdemo.utils.init.InitDataUtil;
import sunlearning.sunlearningdemo.utils.widegt.NoExistDataTextTip;

/**
 * Created by chenny on 2018/4/3.
 */

public class CourseSearchActivity extends Activity{
    private Button backBtn;
    private EditText searchContentET;
    private Button searchGoBtn;
    private NoExistDataTextTip tip;
    private ListView courseListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_search_top_bar);
        backBtn=findViewById(R.id.study_search__back);
        searchContentET=findViewById(R.id.study_search_edit_text);
        searchGoBtn=findViewById(R.id.study_search_btn);
        tip=findViewById(R.id.study_search_no_exist_data);
        courseListView=findViewById(R.id.study_search_list_view);

        initWidget();
        initEvent();

    }

    private void initWidget() {
        //设置搜索按钮不能点击
        searchGoBtn.setClickable(false);
        //listView隐藏
        courseListView.setVisibility(View.GONE);
        //tip隐藏
        tip.setVisibility(View.GONE);
    }



    private void initEvent() {
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        searchContentET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String content = s.toString();
                if(content!=null&&content.trim().length()>0){
                    searchGoBtn.setClickable(true);
                }else{
                    searchGoBtn.setClickable(false);
                }

            }
        });

        searchGoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchContent=searchContentET.getText().toString();
                List<CourseEntity> courses = InitDataUtil.getCoursesInitData();
                List<CourseEntity> validDatas=new ArrayList<CourseEntity>();
                for(CourseEntity course:courses){
                    if(course.getName().contains(searchContent)){
                        validDatas.add(course);
                    }
                }

                //查询到课程数据
                if(validDatas.size()>0){
                    tip.setVisibility(View.GONE);
                    courseListView.setVisibility(View.VISIBLE);
                    courseListView.setAdapter(new CourseAdapter(validDatas,getApplicationContext()));
                }else{
                    courseListView.setVisibility(View.GONE);
                    tip.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
