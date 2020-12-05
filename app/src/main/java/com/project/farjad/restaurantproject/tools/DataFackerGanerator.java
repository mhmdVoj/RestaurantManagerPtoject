package com.project.farjad.restaurantproject.tools;


import com.project.farjad.restaurantproject.R;
import com.project.farjad.restaurantproject.model.BazKhord;
import com.project.farjad.restaurantproject.model.Ghaza;
import com.project.farjad.restaurantproject.model.NoeGhaza;

import java.util.ArrayList;
import java.util.List;

public class DataFackerGanerator {
    public static List<NoeGhaza> getNoeGahaza(){
        List<NoeGhaza> list = new ArrayList<>();
        NoeGhaza noeGhaza = new NoeGhaza();
        noeGhaza.setName("فست فود");
        noeGhaza.setImgResource(R.drawable.ic_fast_food);

        NoeGhaza noeGhaza1 = new NoeGhaza();
        noeGhaza1.setName("خورشتی");
        noeGhaza1.setImgResource(R.drawable.ic_stew);

        NoeGhaza noeGhaza2 = new NoeGhaza();
        noeGhaza2.setName("پیتزا");
        noeGhaza2.setImgResource(R.drawable.ic_pizza);

        NoeGhaza noeGhaza3 = new NoeGhaza();
        noeGhaza3.setName("سالاد");
        noeGhaza3.setImgResource(R.drawable.ic_salad);

        NoeGhaza noeGhaza4 = new NoeGhaza();
        noeGhaza4.setName("دریایی");
        noeGhaza4.setImgResource(R.drawable.ic_sea_food);

        NoeGhaza noeGhaza5 = new NoeGhaza();
        noeGhaza5.setName("نوشیدنی");
        noeGhaza5.setImgResource(R.drawable.ic_drinks);

        NoeGhaza noeGhaza6 = new NoeGhaza();
        noeGhaza6.setName("صبحانه");
        noeGhaza6.setImgResource(R.drawable.ic_breakfast);

        NoeGhaza noeGhaza7 = new NoeGhaza();
        noeGhaza7.setName("مرغ");
        noeGhaza7.setImgResource(R.drawable.ic_chicken);

        NoeGhaza noeGhaza8 = new NoeGhaza();
        noeGhaza8.setName("دسر");
        noeGhaza8.setImgResource(R.drawable.ic_dessert);

        NoeGhaza noeGhaza9 = new NoeGhaza();
        noeGhaza9.setName("بستنی");
        noeGhaza9.setImgResource(R.drawable.ic_ice_cream);

        list.add(noeGhaza);
        list.add(noeGhaza2);
        list.add(noeGhaza3);
        list.add(noeGhaza4);
        list.add(noeGhaza5);
        list.add(noeGhaza6);
        list.add(noeGhaza1);
        list.add(noeGhaza8);
        list.add(noeGhaza9);
        list.add(noeGhaza7);
        return list;
    }

    public static List<Ghaza> getGhaza(){
        List<Ghaza> ghazas = new ArrayList<>();
        Ghaza ghaza = new Ghaza();
        ghaza.setName("سبزی پلو با ماهی");
        ghaza.setImgGhaza(R.drawable.mahi);
        ghaza.setNomre(4);
        ghaza.setMojodi(false);
        ghaza.setTozih("سبزی پلو با ماهی یکی از غذاهای بسیار پر طرفدار و مهم برای ایرانیان است. این غذای خوشمزه علاوه بر اینکه در طول سال طرفداران خاص خودش را دارد به عنوان یک غذای مناسبتی هم شناخته می شود که در شب تحویل سال ( عید نوروز ) طبخ می شود.");
        ghaza.setGheymat("۴۵۰۰۰ تومان");

        Ghaza ghaza1 = new Ghaza();
        ghaza1.setName("قرمه سبزی");
        ghaza1.setImgGhaza(R.drawable.ghorme_sabzi);
        ghaza1.setNomre(3);
        ghaza1.setMojodi(true);
        ghaza1.setTozih("قورمه سبزی غذای که به جرات می توان گفت بیشتر مردم ایران آن را دوست دارند و در بین مردم طوری جا افتاده است که هر زنی که بتواند قورمه سبزی را به خوبی بپزد یک آشپز کامل و ماهر است . یعنی به عبارتی این غذا نقطه سنجش مهارت آشپزی بانوان ایرانی است. جالب است بدانید که در تمام دنیا نیز اصلالت لیران غذا را منتسب به ایرانی ها می دانند.");
        ghaza1.setGheymat("۳۲۰۰۰ تومان");

        Ghaza ghaza2 = new Ghaza();
        ghaza2.setName("همبرگر");
        ghaza2.setImgGhaza(R.drawable.burger);
        ghaza2.setNomre(4);
        ghaza2.setMojodi(true);
        ghaza2.setTozih("همبرگر یکی از قدیمی ترین و پرطرفدارترین غذاهای فست فودی محسوب می شود که به عنوان یک غذای بین المللی در سراسر جهان شناخته شده است. محبوبیت همبرگر در جهان خیلی زیاد است و به همین دلیل برگرهای دیگر مثل چیز برگر ، چیکن برگر و … به وجود آمدند.\n" +
                "\n" +
                "همبرگر در کشور عزیزمان ایران هم از محبوبیت بسیار زیادی برخوردا است و از غذاهای فست فودی محسوب می شود که کمتر کسی را می توانید پیدا کنید که آن را نپسندد. در صورتی که منع مصرف گوشت دارید می توانید همبرگر را با سویا درست کنید.");
        ghaza2.setGheymat("۲۳۰۰۰ تومان");

        Ghaza ghaza3 = new Ghaza();
        ghaza3.setName("سالاد سزار");
        ghaza3.setImgGhaza(R.drawable.salad_sezar);
        ghaza3.setNomre(2);
        ghaza3.setMojodi(true);
        ghaza3.setTozih("به گزارش همشهری آنلاین، سالاد سزار شاید بعد از سالاد شیرازی معروف\u200Cترین و محبوب\u200Cترین سالاد در ایران باشد. سالاد پرطرفداری که این روزها در منوی اکثر کافه\u200Cها و رستوران\u200Cهای شهر پیدا می\u200Cشود. جالب است بدانید سالاد سزار اولین بار توسط رستوران\u200Cداری به نام سزار کاردینی در مکزیک تهیه شد.\n" +
                "\n" +
                "کاردینی در اصل یک سرآشپز، رستوران\u200Cدار و هتل\u200Cدار ایتالیایی بود که برای اولین بار در سال ۱۹۲۴ این سالاد را با مواد غذایی موجود در آشپزخانه\u200Cاش تهیه کرد. طرز تهیه سالاد سزار و سس آن بسیار ساده است.");
        ghaza3.setGheymat("۱۸۰۰۰ تومان");


        Ghaza ghaza4 = new Ghaza();
        ghaza4.setName("املت");
        ghaza4.setImgGhaza(R.drawable.omlet);
        ghaza4.setNomre(4);
        ghaza4.setMojodi(false);
        ghaza4.setTozih("طرز تهیه و نکات طلایی املت خوشمزه با رب یا گوجه\u200Cفرنگی قهوه\u200Cخانه\u200Cای حرفه\u200Cای منتشر شده در ۱۹-۰۸-۹۷ 171636 بازدید 30 دیدگاه\n" +
                "مدت زمان تقریبی مطالعه : 7 دقیقه\n" +
                "طرز تهیه و نکات طلایی املت خوشمزه با رب یا گوجه\u200Cفرنگی قهوه\u200Cخانه\u200Cای حرفه\u200Cای\n" +
                "املت گوجه\u200Cفرنگی از آن\u200Cدسته غذاهای ساده و خوشمزه و بسیار محبوب ایرانی است که برای تمام وعده\u200Cهای غذا در طول شبانه\u200Cروز مناسب و پرطرفدار است. بسیاری از افراد تصور می\u200Cکنند املت گوجه\u200Cفرنگی یک غذای ساده و دم دستی است که مبتدی\u200Cترین افراد در امر آشپزی هم قادرند آن را عمل بیاورند اما واقعیت چیز دیگری است. اگر می\u200Cخواهید یک املت گوجه\u200Cفرنگی حرفه\u200Cای و خوشمزه با طعم املت\u200Cهای رستورانی و کافه\u200Cهای قدیمی و مشهور درست کنید باید فوت و فن\u200Cهای درست کردن املت حرفه\u200Cای را بلد باشید. ");
        ghaza4.setGheymat("۹۰۰۰ تومان");

        Ghaza ghaza5 = new Ghaza();
        ghaza5.setName("پیتزا گوشت و قارچ");
        ghaza5.setImgGhaza(R.drawable.pizza_ghosht);
        ghaza5.setNomre(5);
        ghaza5.setMojodi(true);
        ghaza5.setTozih("این روزها کمتر کسی پیدا می شود که علاقه ای به پیتزا نداشته باشد. پیتزا از غذاهای بین المللی است که در ایران نیز بسیار پرطرفدار است. یکی از انواع محبوب این غذا، پیتزا قارچ و گوشت است؛ زیرا در تهیه آن از هیچ گونه گوشت فرآوری شده ای استفاده نمی شود.\n" +
                "\n" +
                "این غذا به علت وجود قارچ و پنیر و گوشت، کالری بالایی دارد و برای کسانی که می خواهند یک غذای سالم بخورند، گزینه مناسب تری از انواع پیتزاهای تهیه شده با سوسیس و کالباس محسوب می شود.");
        ghaza5.setGheymat("۲۹۰۰۰ تومان");

        Ghaza ghaza6 = new Ghaza();
        ghaza6.setName("بستنی میوه ای");
        ghaza6.setImgGhaza(R.drawable.bastani_mive);
        ghaza6.setNomre(5);
        ghaza6.setMojodi(true);
        ghaza6.setTozih("توی گرمای تابستان معمولا آدم دلش هوس دسرهای خنک میکنه.\n" +
                "\n" +
                "حالا فکر کنید از بیرون بیاید و در حالی که هوا خیلی گرمه یک بستنی میوه ای خونگی خوشمزه یا بستنی یخی توی فریزرتون باشه.\n" +
                "\n" +
                "این بستنی را می تونید با میوه های مختلف درست کنید.\n" +
                "\n" +
                "حتی وقتی میوه ها کمی توی یخچال موندن و نرم شدن و شما نمیدونید باهاشون چیکار کنید، درست کردن بستنی خونگی یک گزینه ی عالیه هست.\n" +
                "\n" +
                "طرز تهیه 7 بستنی میوه ای خانگی با طعم های فوق العاده");
        ghaza6.setGheymat("۷۰۰۰ تومان");

        Ghaza ghaza7 = new Ghaza();
        ghaza7.setName("کیک بستنی");
        ghaza7.setImgGhaza(R.drawable.cake_bastani);
        ghaza7.setNomre(3);
        ghaza7.setMojodi(true);
        ghaza7.setTozih("کیک بستنی ساده یکی از انواع کیک بستنیه که خیلی راحت آماده میشه و طعم بی نظیری داره. توی این دستور شما میتونین هر مقداری که دوست دارین مواد اولیه رو کم یا زیاد کنین. میتونین از انواع کیک ها و بستنی ها استفاده کنین. هیچ محدودیتی توی طعم و اندازه مواد اولیه این کیک بستنی وجود نداره. البته ما توی این دستور از کیک وانیلی به همراه بستنی وانیلی با تکه های کوکی شکلاتی استفاده کردیم که خیلی خوشمزست.");
        ghaza7.setGheymat("۱۲۰۰۰ تومان");

        Ghaza ghaza8 = new Ghaza();
        ghaza8.setName("بستنی شکلاتی");
        ghaza8.setImgGhaza(R.drawable.bastani_shokolati);
        ghaza8.setNomre(4);
        ghaza8.setMojodi(false);
        ghaza8.setTozih("به گزارش گروه وبگردی باشگاه خبرنگاران جوان؛ بسیاری از افراد تحمل تابستان و هوای گرم آن را ندارد و با فرارسیدن تابستان کلافگی آن ها را فرا میگیرد. را های مختلفی برای مقابله با گرما وجود دارد. بیشتر از افراد به دوش آب سرد و کولر، برخی به استخر وتعدادی نیز سفر و دریا را ترجیح می دهند.");
        ghaza8.setGheymat("۷۰۰۰ تومان");

        Ghaza ghaza9 = new Ghaza();
        ghaza9.setName("بستنی سننتی");
        ghaza9.setImgGhaza(R.drawable.bastani_sonati);
        ghaza9.setNomre(4);
        ghaza9.setMojodi(true);
        ghaza9.setTozih("درست است که این روزها بستنی مدل های مختلفی دارد. بستنی چوبی، اسکوپی و کاسه ای در طعم های مختلف همه جا پیدا میشوند و حتی خوراکی های ترکیبی خوشمزه مثل کیک بستنی، معجون و شیک های متنوع هم هستند. اما بستنی سنتی هنوز هم طرفداران خودش را دارد. هیچ چیزی مثل یک بستنی سنتی با عطر و طعم زعفران و گلاب نیست. بستنی سنتی ایرانی را میتوانید در همه فصل های سال در خانه درست کنید و از آن لذت ببرید. بستنی سنتی با ثعلب تهیه میشود. پس قبل از شروع به تهیه بستنی زعفرانی با ثعلب این پودر را از لوازم قنادی یا عطاری تهیه کنید.");
        ghaza9.setGheymat("۱۵۰۰۰ تومان");


        ghazas.add(ghaza);
        ghazas.add(ghaza1);
        ghazas.add(ghaza2);
        ghazas.add(ghaza3);
        ghazas.add(ghaza4);
        ghazas.add(ghaza5);
        ghazas.add(ghaza6);
        ghazas.add(ghaza7);
        ghazas.add(ghaza8);
        ghazas.add(ghaza9);
        return ghazas;

    }

    public static List<BazKhord> getComments(){
        List<BazKhord> list =new ArrayList<>();
        BazKhord bazKhord =new BazKhord();
        bazKhord.setMant("غذای خوبی بود اما سرد سرو شد");
        bazKhord.setTarikh("امیر ساعت 13:44 این باز خورد را گذاشته است");

        BazKhord bazKhord1 =new BazKhord();
        bazKhord1.setMant("عالی بود خدمات هم درجه یک بود");
        bazKhord1.setTarikh("امیر ساعت 22:10 این باز خورد را گذاشته است");

        BazKhord bazKhord2 =new BazKhord();
        bazKhord2.setMant("ممنون از غذای خوبیتون");
        bazKhord2.setTarikh("سارا ساعت 16:44 این باز خورد را گذاشته است");
        list.add(bazKhord1);
        list.add(bazKhord2);
        return list;
    }

}
