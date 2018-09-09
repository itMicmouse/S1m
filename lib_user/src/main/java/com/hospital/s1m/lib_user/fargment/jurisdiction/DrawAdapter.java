package com.hospital.s1m.lib_user.fargment.jurisdiction;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.hospital.s1m.lib_base.utils.OnItreamClickListener;
import com.hospital.s1m.lib_user.R;

import java.util.List;

/**
 * Created by zyjk654764 on 2018/9/4.
 */

public class DrawAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<String> list;
    private LayoutInflater inflater;
    private OnItreamClickListener onItreamClickListener;
    private final int ITEM_TITLE=0;
    private final int ITEM_IMAGE=1;
    private AllViewHolder allViewHolder;
    private LastViewHolder lastViewHolder;
    //先声明一个int成员变量
    private int thisPosition;
    public DrawAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }
    public void setOnItemClickListener(OnItreamClickListener onItemClickListener){
        this.onItreamClickListener=onItemClickListener;
    }
    //再定义一个int类型的返回值方法
    public int getthisPosition() {
        return thisPosition;
    }
    //其次定义一个方法用来绑定当前参数值的方法
    //此方法是在调用此适配器的地方调用的，此适配器内不会被调用到
    public void setThisPosition(int thisPosition) {
        this.thisPosition = thisPosition;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType==ITEM_IMAGE){
            View view=inflater.inflate(R.layout.user_draw_last, parent, false);
            lastViewHolder=new LastViewHolder(view);
            return lastViewHolder;
        }else{
            View view=inflater.inflate(R.layout.user_draw_list,parent,false);
            allViewHolder=new AllViewHolder(view);
            return allViewHolder;
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

            if(list.get(position).equals("快速挂号")){
                lastViewHolder= (LastViewHolder) holder;
                //改变背景颜色
                if (position == getthisPosition()) {
                    lastViewHolder.last_rll.setBackgroundColor(Color.parseColor("#BDBDBD"));
                    lastViewHolder.last_text.setTextColor(Color.parseColor("#4285F4"));
                } else {
                    lastViewHolder.last_rll.setBackgroundColor(Color.parseColor("#FAFAFA"));
                    lastViewHolder.last_text.setTextColor(Color.parseColor("#000000"));
                }
               lastViewHolder.last_rll.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       if(onItreamClickListener!=null){
                           onItreamClickListener.onItemClick(position);
                       }
                   }
               });
            }else{
                 allViewHolder= (AllViewHolder) holder;
                allViewHolder.draw_text.setText(list.get(position));
                //改变背景颜色
                if (position == getthisPosition()) {
                   allViewHolder.draw_rll.setBackgroundColor(Color.parseColor("#BDBDBD"));
                   allViewHolder.draw_text.setTextColor(Color.parseColor("#4285F4"));
                } else {
                    allViewHolder.draw_rll.setBackgroundColor(Color.parseColor("#FAFAFA"));
                    allViewHolder.draw_text.setTextColor(Color.parseColor("#000000"));
                }
                allViewHolder.draw_rll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(onItreamClickListener!=null){
                            onItreamClickListener.onItemClick(position);
                        }
                    }
                });
            }
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position).equals("快速挂号")){
            return  ITEM_IMAGE;//最后一个
        }else{
            return  ITEM_TITLE;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class LastViewHolder extends RecyclerView.ViewHolder {


        private final RelativeLayout last_rll;
        private final Switch on_off;
        private final ImageView puls;
        private final TextView last_text;

        public LastViewHolder(View itemView) {
            super(itemView);
            last_rll=itemView.findViewById(R.id.last_rll);
            on_off=itemView.findViewById(R.id.on_off);
            last_text=itemView.findViewById(R.id.last_text);
            puls=itemView.findViewById(R.id.right_plus);
        }
    }
    class AllViewHolder extends RecyclerView.ViewHolder {


        private final TextView draw_text;
        private final RelativeLayout draw_rll;

        public AllViewHolder(View itemView) {
            super(itemView);
            draw_text=itemView.findViewById(R.id.draw_text);
            draw_rll=itemView.findViewById(R.id.draw_rll);
        }
    }
}
