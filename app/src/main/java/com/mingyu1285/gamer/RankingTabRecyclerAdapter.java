package com.mingyu1285.gamer;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RankingTabRecyclerAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<RecyclerItem> items;

    public RankingTabRecyclerAdapter(Context context, ArrayList<RecyclerItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView= inflater.inflate(R.layout.recycler_item, parent, false);
        //뷰홀더 객체 생성 및 리턴
        VH holder= new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH)holder;

        //현재번째(position) 데이터를 가진 Item객체 얻어오기
        RecyclerItem item= items.get(position);

        vh.tvName.setText( item.name );
        vh.tvMsg.setText( item.msg );
        //네트워크 이미지를 불러오는 작업을 쉽게 해주는 외부 라이브러리 사용 : Glide
        Glide.with(context).load(item.imgURL).into(vh.iv);
        Glide.with(context).load(item.profileImg).into(vh.civ);



    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //아이템뷰의 안에 있는 뷰들의 참조변수를 멤버로 가진 클래스
    class VH extends RecyclerView.ViewHolder{

        CircleImageView civ;
        TextView tvName;
        TextView tvMsg;
        ImageView iv;

        public VH(@NonNull final View itemView) {
            super(itemView);

            civ= itemView.findViewById(R.id.iv_profile);
            tvName= itemView.findViewById(R.id.tv_name);
            tvMsg= itemView.findViewById(R.id.tv_msg);
            iv= itemView.findViewById(R.id.iv);

            //아이템 클릭 리스너 생성 및 설정
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //현재 클릭한 번째(getLayoutPosition())의 데이터 참조
                    RecyclerItem item= items.get(getLayoutPosition());

                    Intent intent= new Intent(context, DetailActivity.class);

                    //전달할 데이터 추가
                    intent.putExtra("Name", item.name);
                    intent.putExtra("img", item.profileImg);

                    //전환효과 (api 21버전 이상에서만 가능함)
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                        ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation((Activity)context, new Pair<View, String>(civ, "IMG"));
                        context.startActivity(intent, options.toBundle());
                    }else{
                        context.startActivity(intent);
                    }


                }
            });

        }
    }
}
