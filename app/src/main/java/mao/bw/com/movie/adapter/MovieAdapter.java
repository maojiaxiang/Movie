package mao.bw.com.movie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import mao.bw.com.movie.R;
import mao.bw.com.movie.bean.movie.MovieBean;

/**
 * @Auther: 毛佳翔
 * @Date: 2019/6/10 09:34:38
 * @Description: 描述信息
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context context;
    private List<MovieBean> mList =new ArrayList<>();

    public MovieAdapter(Context context) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item01, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
       Glide.with(context).load(mList.get(i).getImageUrl()).into(viewHolder.img);

    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void addAll(List<MovieBean> result) {
        mList.addAll(result);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }
}
