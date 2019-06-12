package mao.bw.com.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import mao.bw.com.movie.R;
import mao.bw.com.movie.bean.AboutBean;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/12 14:27:20
 * @Description: 描述信息
 */
public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.ViewHolder> {
    private Context context;
    private List<AboutBean> mList = new ArrayList<>();

    public AboutAdapter(Context context) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.about_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(mList.get(i).getName());
        viewHolder.sm.setText(mList.get(i).getSummary());
        Glide.with(context).load(mList.get(i).getImageUrl())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void allAdd(List<AboutBean> result) {
        mList.addAll(result);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView name;
        private final TextView sm;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.a_img);
            name = itemView.findViewById(R.id.a_name);
            sm = itemView.findViewById(R.id.a_sm);
        }
    }
}
