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

import java.util.ArrayList;
import java.util.List;

import mao.bw.com.movie.R;
import mao.bw.com.movie.bean.cinema.FuJinBean;
import mao.bw.com.movie.bean.cinema.TuiJianBean;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/12 17:28
 * @Description：描述信息
 */
public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.ViewHolder> {
    private Context context;
    private List<TuiJianBean> mList = new ArrayList<>();

    public NearbyAdapter(Context context, List<TuiJianBean> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.n_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(mList.get(i).getName());
        viewHolder.address.setText(mList.get(i).getAddress());
        viewHolder.n_k.setText(mList.get(i).getCommentTotal());
        Glide.with(context).load(mList.get(i).getLogo()).into(viewHolder.img);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void allAdd(List<TuiJianBean> result) {
       mList.addAll(result);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;
        private final TextView address;
        private final TextView n_k;
        private final TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.n_img);
            address = itemView.findViewById(R.id.n_address);
            n_k = itemView.findViewById(R.id.n_k);
            name = itemView.findViewById(R.id.n_name);
        }
    }
}
