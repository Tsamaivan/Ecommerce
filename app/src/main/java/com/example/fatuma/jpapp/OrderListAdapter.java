package com.example.fatuma.jpapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderViewHolder> {
    List<Order>orderList;
    Context context;
    OrderListItemAdapter ivan;

    public OrderListAdapter(Context context, OrderListItemAdapter ivan) {
        this.context = context;
        this.ivan = ivan;
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView amount;
        TextView name;
        TextView status;
        TextView comment;
        public OrderViewHolder(View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.etamountList);
            name = itemView.findViewById(R.id.itemnamelist);
            status = itemView.findViewById(R.id.itemstatuslist);
            comment = itemView.findViewById(R.id.itemcommentlist);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int itemId = orderList.get(getAdapterPosition()).getItemId();
            ivan.onClick(itemId);


        }
    }

    @Override
    public OrderListAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_itemlist,parent,false);
        return new OrderViewHolder(view);
    }

    public interface OrderListItemAdapter{
        void onClick(int itemId);


    }
    @Override
    public void onBindViewHolder(@NonNull OrderListAdapter.OrderViewHolder holder, int position) {

        Order order = orderList.get(position);
        holder.amount.setText(order.getAmount());
        holder.name.setText(order.getItem());
        holder.status.setText(order.getStatus());
        holder.comment.setText(order.getComment());
    }

    @Override
    public int getItemCount() {
        if (orderList == null){
        return 0;
    }
    return orderList.size();
}
public void setOrderData(List<Order>orderData){
    orderList = orderData;
    notifyDataSetChanged();
    }
}
