package sunlearning.sunlearningdemo.study.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.model.CourseProjectEntity;

/**
 * Created by chenny on 2018/4/3.
 */

public class CourseProjectListAdapter extends BaseAdapter {
    private List<CourseProjectEntity> mData;
    private Context mContent;

    public CourseProjectListAdapter(List<CourseProjectEntity> mData, Context mContent) {
        this.mData = mData;
        this.mContent = mContent;
    }

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mData.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContent).inflate(R.layout.item_list_course_project, null);
            viewHolder = new ViewHolder();
            viewHolder.projectId = convertView.findViewById(R.id.item_list_course_project_id);
            viewHolder.projectIcon = convertView.findViewById(R.id.item_list_course_project_icon);
            viewHolder.projectName = convertView.findViewById(R.id.item_list_course_project_name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        CourseProjectEntity curProject = (CourseProjectEntity) getItem(position);
        viewHolder.projectId.setText(String.valueOf(curProject.getId()));
        viewHolder.projectIcon.setBackgroundResource(curProject.getImg());
        viewHolder.projectName.setText(curProject.getName());
        return convertView;
    }

    static public class ViewHolder {
        public TextView projectId;
        public ImageView projectIcon;
        public TextView projectName;
    }
}
