package com.project.farjad.restaurantproject.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.project.farjad.restaurantproject.R;
import com.project.farjad.restaurantproject.model.Reserve;

import java.util.ArrayList;
import java.util.List;

public class ReservesAdapter extends RecyclerView.Adapter<ReservesAdapter.ReserveViewHolder> {

    private List<Reserve> reserveList;
    private List<Reserve> filterReserveList;
    private onReserveItemListener listener;

    public ReservesAdapter(List<Reserve> reserveList, onReserveItemListener listener) {
        this.reserveList = reserveList;
        this.listener = listener;
        this.filterReserveList = reserveList;
    }

    public void filterReserve(String str){
        filterReserveList =new  ArrayList<>();
        for (Reserve reserve : reserveList) {
            if (reserve.getRozeReserve().equals(str)) {
                filterReserveList.add(reserve);
            }
        }
        notifyDataSetChanged();
    }

    public void removeItem(Reserve reserve){
        for (int i = 0; i < reserveList.size(); i++) {
            if (reserveList.get(i).getId()==reserve.getId()){
                reserveList.remove(reserve);
                notifyItemRemoved(i);
                break;
            }
        }

    }
    @NonNull
    @Override
    public ReserveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ReserveViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.reserves_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ReserveViewHolder holder, int position) {
        holder.bindDateReserve(filterReserveList.get(position));
    }

    @Override
    public int getItemCount() {
        return filterReserveList.size();
    }

    class ReserveViewHolder extends RecyclerView.ViewHolder{
        private TextView txt_type_reservation;
        private TextView txt_name_customer_reservation;
        private TextView txt_shomare_miz_resevsation;
        private TextView txt_time_reservation;
        private TextView txt_time_res_shode;
        private TextView txt_tedad_mihman_reserve;
        private TextView txt_date_reserve;
        private ImageView img_type_reserve;
        private ImageView btn_delete_reservation;

        public ReserveViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_type_reservation = itemView.findViewById(R.id.txt_type_reservation);
            txt_name_customer_reservation = itemView.findViewById(R.id.txt_name_customer_reservation);
            txt_time_reservation = itemView.findViewById(R.id.txt_time_reservation);
            txt_shomare_miz_resevsation = itemView.findViewById(R.id.txt_shomare_miz_resevsation);
            txt_time_res_shode = itemView.findViewById(R.id.txt_time_res_shode);
            btn_delete_reservation = itemView.findViewById(R.id.btn_delete_reservation);
            img_type_reserve = itemView.findViewById(R.id.img_type_reserve);
            txt_tedad_mihman_reserve = itemView.findViewById(R.id.txt_tedad_mihman_reserve);
            txt_date_reserve = itemView.findViewById(R.id.txt_date_reserve);
        }

        public void bindDateReserve(Reserve reserve){
            txt_name_customer_reservation.setText(reserve.getNameMosh());
            txt_time_reservation.setText(reserve.getRozeReserve()+" "+ reserve.getSaatReserve());
            txt_shomare_miz_resevsation.setText("میز شماره "+ reserve.getShomareMiz());
            txt_date_reserve.setText(reserve.getTarikhReserve());
            txt_time_res_shode.setText(" در "+reserve.getTarikhSabtReserve() + " ثبت شده است");
            if (reserve.isVip()){
                img_type_reserve.setImageResource(R.drawable.ic_vip);
                txt_type_reservation.setText("رزرو میز VIP");
            }else {
                img_type_reserve.setImageResource(R.drawable.ic_reservation);
                txt_type_reservation.setText("رزرو میز معمولی");
            }
            txt_tedad_mihman_reserve.setText(reserve.getTedad() + "نفر");
            btn_delete_reservation.setOnClickListener(view->{
                listener.onDeleteReserve(reserve);
            });

        }
    }

    public interface onReserveItemListener{
        void onDeleteReserve(Reserve reserve);
    }
}
