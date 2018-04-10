package sunlearning.sunlearningdemo.examine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.examine.adapter.ExamineSurveyAdapter;
import sunlearning.sunlearningdemo.model.ExamineSurveyEntity;
import sunlearning.sunlearningdemo.utils.init.InitDataUtil;

/**
 * Created by chenny on 2018/4/8.
 */

public class ExamineQuestionnaireFragment extends Fragment {
    private View view;
    private ListView listView;
    private List<ExamineSurveyEntity> surveyList;
    private ExamineSurveyAdapter questionnaireAdapter;

    public ExamineQuestionnaireFragment() {
        super();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_examine_questionnaire, container, false);
        listView=view.findViewById(R.id.examine_questionnaire_list_view);
        initData();
        initWidget();
        initEvent();
        return view;
    }

    private void initEvent() {

    }

    private void initWidget() {
        initListView();
    }

    private void initListView() {
        listView.setAdapter(new ExamineSurveyAdapter(getContext(),surveyList));
    }

    private void initData() {
        surveyList= InitDataUtil.getExamineSurveyList();
    }
}
