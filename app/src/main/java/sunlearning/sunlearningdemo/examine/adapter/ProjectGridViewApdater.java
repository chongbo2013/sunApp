package sunlearning.sunlearningdemo.examine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sunlearning.sunlearningdemo.R;
import sunlearning.sunlearningdemo.model.ExamineProjectEntity;

/**
 * Created by chenny on 2018/4/8.
 */

public class ProjectGridViewApdater extends BaseAdapter {
    private Context mContext;
    private List<ExamineProjectEntity> mData;
    private ViewHolder viewHolder;

    public ProjectGridViewApdater(Context mContext, List<ExamineProjectEntity> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return ((ExamineProjectEntity) getItem(position)).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_examine_project, null);
            viewHolder = new ViewHolder();
            viewHolder.projectId=convertView.findViewById(R.id.item_list_examine_project_id);
            viewHolder.projectImg=convertView.findViewById(R.id.item_list_examine_project_icon);
            viewHolder.projectName=convertView.findViewById(R.id.item_list_examine_project_name);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }

        ExamineProjectEntity projectEntity = (ExamineProjectEntity) getItem(position);
        viewHolder.projectId.setText(String.valueOf(projectEntity.getId()));
        viewHolder.projectImg.setBackgroundResource(projectEntity.getImg());
        viewHolder.projectName.setText(projectEntity.getName());
        return convertView;
    }


    public static class ViewHolder {
        public TextView projectId;
        public ImageView projectImg;
        public TextView projectName;
    }
}
