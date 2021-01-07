package com.project.farjad.restaurantproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.project.farjad.restaurantproject.R;
import com.project.farjad.restaurantproject.model.Ghaza;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SliderAdapterHome extends SliderViewAdapter<SliderAdapterHome.SliderHomeViewHolder> {
    private List<Ghaza> mSliderItems = new ArrayList<>();
    private SliderEventListener sliderEventListener;


    public SliderAdapterHome(Context context , SliderEventListener sliderEventListener) {
        this.sliderEventListener = sliderEventListener;
    }

    public void renewItems(List<Ghaza> sliderItems) {
        this.mSliderItems = sliderItems;
        notifyDataSetChanged();
    }

    public void addItem(Ghaza sliderItem) {
        this.mSliderItems.add(sliderItem);
        notifyDataSetChanged();
    }


    @Override
    public SliderHomeViewHolder onCreateViewHolder(ViewGroup parent) {
        return new SliderHomeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout_item, null));
    }

    @Override
    public void onBindViewHolder(SliderHomeViewHolder viewHolder, int position) {
        viewHolder.BindSlider(mSliderItems.get(position));
    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    public class SliderHomeViewHolder extends SliderViewAdapter.ViewHolder{
        private SimpleDraweeView img_food_slider;
        private TextView txt_name_food_slider;
        private TextView isMojod_slider;
        private TextView txt_price_slider;
        private TextView type_food_slider;
        private RatingBar rating_slider;
        public SliderHomeViewHolder(View itemView) {
            super(itemView);
            txt_name_food_slider = itemView.findViewById(R.id.txt_name_food_slider);
            isMojod_slider = itemView.findViewById(R.id.isMojod_slider);
            img_food_slider = itemView.findViewById(R.id.img_food_slider);
            txt_price_slider = itemView.findViewById(R.id.txt_price_slider);
            rating_slider= itemView.findViewById(R.id.rating_slider);
            type_food_slider= itemView.findViewById(R.id.type_food_slider);

        }
        public void BindSlider(Ghaza slidesHome){
            txt_name_food_slider.setText(slidesHome.getName());
            rating_slider.setRating(slidesHome.getNomre());
            img_food_slider.setImageURI(slidesHome.getImgGhaza());
            type_food_slider.setText(slidesHome.getType());
            txt_price_slider.setText(slidesHome.getGheymat() + " تومان ");
            if (slidesHome.isMojodi())
                isMojod_slider.setText("موجود");
            else isMojod_slider.setText("تمام شده");
            itemView.setOnClickListener(n -> {
                sliderEventListener.OnClickSlide(slidesHome);
            });
        }
    }

    public interface SliderEventListener{
        void OnClickSlide(Ghaza slidesHome);
    }

}


