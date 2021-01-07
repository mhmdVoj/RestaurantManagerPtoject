package com.project.farjad.restaurantproject.tools;


import com.project.farjad.restaurantproject.R;
import com.project.farjad.restaurantproject.model.BazKhord;
import com.project.farjad.restaurantproject.model.Factor;
import com.project.farjad.restaurantproject.model.Ghaza;
import com.project.farjad.restaurantproject.model.Moshtari;
import com.project.farjad.restaurantproject.model.NoeGhaza;
import com.project.farjad.restaurantproject.model.Personel;
import com.project.farjad.restaurantproject.model.Reserve;
import com.project.farjad.restaurantproject.model.Semat;

import java.util.ArrayList;
import java.util.List;

public class DataFakerGenerator {
    public static List<NoeGhaza> getNoeGahaza() {
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

    public static List<Ghaza> getGhaza() {
        List<Ghaza> ghazas = new ArrayList<>();
        Ghaza ghaza = new Ghaza();
        ghaza.setName("سبزی پلو با ماهی");
        //ghaza.setImgGhaza(R.drawable.mahi);
        ghaza.setImgGhaza("https://kalleh.com/book/wp-content/uploads/sites/2/2019/02/mahi.jpg");
        ghaza.setNomre(4);
        ghaza.setType("دریایی");
        ghaza.setMojodi(false);
        ghaza.setTozih("سبزی پلو با ماهی یکی از غذاهای بسیار پر طرفدار و مهم برای ایرانیان است. این غذای خوشمزه علاوه بر اینکه در طول سال طرفداران خاص خودش را دارد به عنوان یک غذای مناسبتی هم شناخته می شود که در شب تحویل سال ( عید نوروز ) طبخ می شود.");
        ghaza.setGheymat("48000");
        ghaza.setId_noeGhaza(4);

        Ghaza ghaza1 = new Ghaza();
        ghaza1.setName("قرمه سبزی");
        //ghaza1.setImgGhaza(R.drawable.ghorme_sabzi);
        ghaza1.setImgGhaza("https://blog.okala.com/wp-content/uploads/2020/09/%D9%82%D9%88%D8%B1%D9%85%D9%87-%D8%B3%D8%A8%D8%B2%DB%8C.jpg");
        ghaza1.setNomre(3);
        ghaza1.setType("خورشتی");
        ghaza1.setMojodi(true);
        ghaza1.setTozih("قورمه سبزی غذای که به جرات می توان گفت بیشتر مردم ایران آن را دوست دارند و در بین مردم طوری جا افتاده است که هر زنی که بتواند قورمه سبزی را به خوبی بپزد یک آشپز کامل و ماهر است . یعنی به عبارتی این غذا نقطه سنجش مهارت آشپزی بانوان ایرانی است. جالب است بدانید که در تمام دنیا نیز اصلالت لیران غذا را منتسب به ایرانی ها می دانند.");
        ghaza1.setGheymat("32000");
        ghaza1.setId_noeGhaza(7);

        Ghaza ghaza2 = new Ghaza();
        ghaza2.setName("همبرگر");
        //ghaza2.setImgGhaza(R.drawable.burger);
        ghaza2.setImgGhaza("https://assets.epicurious.com/photos/5c745a108918ee7ab68daf79/master/pass/Smashburger-recipe-120219.jpg");
        ghaza2.setNomre(4);
        ghaza2.setType("فست فود");
        ghaza2.setId_noeGhaza(1);
        ghaza2.setMojodi(true);
        ghaza2.setTozih("همبرگر یکی از قدیمی ترین و پرطرفدارترین غذاهای فست فودی محسوب می شود که به عنوان یک غذای بین المللی در سراسر جهان شناخته شده است. محبوبیت همبرگر در جهان خیلی زیاد است و به همین دلیل برگرهای دیگر مثل چیز برگر ، چیکن برگر و … به وجود آمدند.\n" +
                "\n" +
                "همبرگر در کشور عزیزمان ایران هم از محبوبیت بسیار زیادی برخوردا است و از غذاهای فست فودی محسوب می شود که کمتر کسی را می توانید پیدا کنید که آن را نپسندد. در صورتی که منع مصرف گوشت دارید می توانید همبرگر را با سویا درست کنید.");
        ghaza2.setGheymat("25000");

        Ghaza ghaza3 = new Ghaza();
        ghaza3.setName("سالاد سزار");
        //ghaza3.setImgGhaza(R.drawable.salad_sezar);
        ghaza3.setImgGhaza("https://kalleh.com/book/wp-content/uploads/sites/2/2017/12/Untitled-1_32-1.jpg");
        ghaza3.setNomre(2);
        ghaza3.setType("سالاد");
        ghaza3.setId_noeGhaza(3);
        ghaza3.setMojodi(true);
        ghaza3.setTozih("به گزارش همشهری آنلاین، سالاد سزار شاید بعد از سالاد شیرازی معروف\u200Cترین و محبوب\u200Cترین سالاد در ایران باشد. سالاد پرطرفداری که این روزها در منوی اکثر کافه\u200Cها و رستوران\u200Cهای شهر پیدا می\u200Cشود. جالب است بدانید سالاد سزار اولین بار توسط رستوران\u200Cداری به نام سزار کاردینی در مکزیک تهیه شد.\n" +
                "\n" +
                "کاردینی در اصل یک سرآشپز، رستوران\u200Cدار و هتل\u200Cدار ایتالیایی بود که برای اولین بار در سال ۱۹۲۴ این سالاد را با مواد غذایی موجود در آشپزخانه\u200Cاش تهیه کرد. طرز تهیه سالاد سزار و سس آن بسیار ساده است.");
        ghaza3.setGheymat("14000");


        Ghaza ghaza4 = new Ghaza();
        ghaza4.setName("املت");
        ghaza4.setType("صبحانه");
        ghaza4.setId_noeGhaza(6);
        //ghaza4.setImgGhaza(R.drawable.omlet);
        ghaza4.setImgGhaza("https://gymito.com/blog/wp-content/uploads/2019/11/%D8%B7%D8%B1%D8%B2-%D8%AA%D9%87%DB%8C%D9%87-%D8%A7%D9%85%D9%84%D8%AA-480x270.jpg");
        ghaza4.setNomre(4);
        ghaza4.setMojodi(false);
        ghaza4.setTozih("طرز تهیه و نکات طلایی املت خوشمزه با رب یا گوجه\u200Cفرنگی قهوه\u200Cخانه\u200Cای حرفه\u200Cای منتشر شده در ۱۹-۰۸-۹۷ 171636 بازدید 30 دیدگاه\n" +
                "مدت زمان تقریبی مطالعه : 7 دقیقه\n" +
                "طرز تهیه و نکات طلایی املت خوشمزه با رب یا گوجه\u200Cفرنگی قهوه\u200Cخانه\u200Cای حرفه\u200Cای\n" +
                "املت گوجه\u200Cفرنگی از آن\u200Cدسته غذاهای ساده و خوشمزه و بسیار محبوب ایرانی است که برای تمام وعده\u200Cهای غذا در طول شبانه\u200Cروز مناسب و پرطرفدار است. بسیاری از افراد تصور می\u200Cکنند املت گوجه\u200Cفرنگی یک غذای ساده و دم دستی است که مبتدی\u200Cترین افراد در امر آشپزی هم قادرند آن را عمل بیاورند اما واقعیت چیز دیگری است. اگر می\u200Cخواهید یک املت گوجه\u200Cفرنگی حرفه\u200Cای و خوشمزه با طعم املت\u200Cهای رستورانی و کافه\u200Cهای قدیمی و مشهور درست کنید باید فوت و فن\u200Cهای درست کردن املت حرفه\u200Cای را بلد باشید. ");
        ghaza4.setGheymat("7000");

        Ghaza ghaza5 = new Ghaza();
        ghaza5.setName("پیتزا گوشت و قارچ");
        ghaza5.setType("پیتزا");
        ghaza5.setId_noeGhaza(2);
        //ghaza5.setImgGhaza(R.drawable.pizza_ghosht);
        ghaza5.setImgGhaza("https://cdn.sarashpazpapion.com/files/recipes/pictures/web/2016/10/8/t8b6roj4fobce3ohiepofgprmtakikkt.jpg");
        ghaza5.setNomre(5);
        ghaza5.setMojodi(true);
        ghaza5.setTozih("این روزها کمتر کسی پیدا می شود که علاقه ای به پیتزا نداشته باشد. پیتزا از غذاهای بین المللی است که در ایران نیز بسیار پرطرفدار است. یکی از انواع محبوب این غذا، پیتزا قارچ و گوشت است؛ زیرا در تهیه آن از هیچ گونه گوشت فرآوری شده ای استفاده نمی شود.\n" +
                "\n" +
                "این غذا به علت وجود قارچ و پنیر و گوشت، کالری بالایی دارد و برای کسانی که می خواهند یک غذای سالم بخورند، گزینه مناسب تری از انواع پیتزاهای تهیه شده با سوسیس و کالباس محسوب می شود.");
        ghaza5.setGheymat("25000");

        Ghaza ghaza6 = new Ghaza();
        ghaza6.setName("بستنی میوه ای");
        ghaza6.setType("بستنی");
        ghaza6.setId_noeGhaza(9);
        //ghaza6.setImgGhaza(R.drawable.bastani_mive);
        ghaza6.setImgGhaza("https://cdn.yjc.ir/files/fa/news/1397/4/19/8297531_512.jpg");
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
        ghaza6.setGheymat("6000");

        Ghaza ghaza7 = new Ghaza();
        ghaza7.setName("کیک بستنی");
        //ghaza7.setImgGhaza(R.drawable.cake_bastani);
        ghaza7.setImgGhaza("https://kalleh.com/book/wp-content/uploads/sites/2/2019/02/Oreo-Ice-Cream-Cake-3.jpg");
        ghaza7.setNomre(3);
        ghaza7.setId_noeGhaza(9);
        ghaza7.setMojodi(true);
        ghaza7.setType("بستنی");
        ghaza7.setTozih("کیک بستنی ساده یکی از انواع کیک بستنیه که خیلی راحت آماده میشه و طعم بی نظیری داره. توی این دستور شما میتونین هر مقداری که دوست دارین مواد اولیه رو کم یا زیاد کنین. میتونین از انواع کیک ها و بستنی ها استفاده کنین. هیچ محدودیتی توی طعم و اندازه مواد اولیه این کیک بستنی وجود نداره. البته ما توی این دستور از کیک وانیلی به همراه بستنی وانیلی با تکه های کوکی شکلاتی استفاده کردیم که خیلی خوشمزست.");
        ghaza7.setGheymat("32000");

        Ghaza ghaza8 = new Ghaza();
        ghaza8.setName("بستنی شکلاتی");
        //ghaza8.setImgGhaza(R.drawable.bastani_shokolati);
        ghaza8.setImgGhaza("https://zarinbano.com/wp-content/uploads/%D8%B1%D9%88%D8%B4-%D8%AF%D8%B1%D8%B3%D8%AA-%DA%A9%D8%B1%D8%AF%D9%86-%D8%A8%D8%B3%D8%AA%D9%86%DB%8C-%D8%B4%DA%A9%D9%84%D8%A7%D8%AA%DB%8C-%D8%AF%D8%B1-%D8%AE%D8%A7%D9%86%D9%87.jpg");
        ghaza8.setNomre(4);
        ghaza8.setId_noeGhaza(9);
        ghaza8.setType("بستنی");
        ghaza8.setMojodi(false);
        ghaza8.setTozih("به گزارش گروه وبگردی باشگاه خبرنگاران جوان؛ بسیاری از افراد تحمل تابستان و هوای گرم آن را ندارد و با فرارسیدن تابستان کلافگی آن ها را فرا میگیرد. را های مختلفی برای مقابله با گرما وجود دارد. بیشتر از افراد به دوش آب سرد و کولر، برخی به استخر وتعدادی نیز سفر و دریا را ترجیح می دهند.");
        ghaza8.setGheymat("6000");

        Ghaza ghaza9 = new Ghaza();
        ghaza9.setName("بستنی سننتی");
        //ghaza9.setImgGhaza(R.drawable.bastani_sonati);
        ghaza9.setImgGhaza("https://gymito.com/blog/wp-content/uploads/2020/03/%D8%B7%D8%B1%D8%B2-%D8%AA%D9%87%DB%8C%D9%87-%D8%A8%D8%B3%D8%AA%D9%86%DB%8C-%D8%B3%D9%86%D8%AA%DB%8C-1-740x414.jpg");
        ghaza9.setNomre(4);
        ghaza9.setMojodi(true);
        ghaza9.setId_noeGhaza(9);
        ghaza9.setType("بستنی");
        ghaza9.setTozih("درست است که این روزها بستنی مدل های مختلفی دارد. بستنی چوبی، اسکوپی و کاسه ای در طعم های مختلف همه جا پیدا میشوند و حتی خوراکی های ترکیبی خوشمزه مثل کیک بستنی، معجون و شیک های متنوع هم هستند. اما بستنی سنتی هنوز هم طرفداران خودش را دارد. هیچ چیزی مثل یک بستنی سنتی با عطر و طعم زعفران و گلاب نیست. بستنی سنتی ایرانی را میتوانید در همه فصل های سال در خانه درست کنید و از آن لذت ببرید. بستنی سنتی با ثعلب تهیه میشود. پس قبل از شروع به تهیه بستنی زعفرانی با ثعلب این پودر را از لوازم قنادی یا عطاری تهیه کنید.");
        ghaza9.setGheymat("10000");

        Ghaza ghaza10 = new Ghaza();
        ghaza10.setName("سالاد كلم");
        //ghaza10.setImgGhaza(R.drawable.salad_kalam);
        ghaza10.setImgGhaza("https://chishi.ir/wp-content/uploads/2020/05/salad-kalam-sefid.jpg");
        ghaza10.setNomre(2);
        ghaza10.setMojodi(false);
        ghaza10.setId_noeGhaza(3);
        ghaza10.setType("سالاد");
        ghaza10.setTozih("سالاد کلم یکی از سالادهای خوشمزه است که در رستوران ها طرفداران زیادی دارد . سالادها انواع مختلفی دارند و توضیح درباره طرز تهیه آنها پایان ناپذیر است و این به دلیل ترکیب رنگ زیبای این خوراکی های خوشمزه و مهمتر از همه سالم بودن آن هاست و البته برای خیلی از افراد استفاده از سس های مختلف نیز در این غذاها می باشد.\n" +
                "در واقع می\u200Cتوان با ترکیب\u200Cکردن مواد غذایی سازگار و خوش طعم با یک سس سالاد که آن\u200Cهم سلیقه\u200Cای و متنوع است یک سالاد خوشمزه تهیه کرد. یکی از انواع سالاد خوشمزه، سالاد کلم سفید و هویج است که معمولا در مراسم عروسی و در رستوران\u200Cها یکی از پایه\u200Cهای ثابت میز غذاست.");
        ghaza10.setGheymat("5000");

        Ghaza ghaza11 = new Ghaza();
        ghaza11.setName("سالاد روسی");
        //ghaza11.setImgGhaza(R.drawable.russian_salad);
        ghaza11.setImgGhaza("https://irancook.ir/wp-content/uploads/2014/12/%D8%B3%D8%A7%D9%84%D8%A7%D8%AF-%D8%B1%D9%88%D8%B3%DB%8C-1280x720.jpg");
        ghaza11.setNomre(3);
        ghaza11.setMojodi(true);
        ghaza11.setId_noeGhaza(3);
        ghaza11.setType("سالاد");
        ghaza11.setTozih("سالاد روسی یکی از انواع سالادهای خوشمزه و پرطرفدار در جهان است که همانطور که از نامش مشخص است متعلق به کشور روسیه می باشد. اگر از طرفداران سالاد الویه هستید توصیه می کنیم سالاد روسی را هم امتحان کنید چون این دو سالاد شباهت زیادی با هم دارند.\n" +
                "\n" +
                "با موادی که در این دستور آشپزی قرار گرفته است می توانید برای ۴ نفر سالاد روسی تهیه کنید. در صورتی که می خواهید مقدار کمتر یا بیشتری سالاد روسی تهیه کنید کافیست مقدار مواد را ضرب یا تقسیم کنید.");
        ghaza11.setGheymat("6500");

        Ghaza ghaza12 = new Ghaza();
        ghaza12.setName("تيراميسو");
        //ghaza12.setImgGhaza(R.drawable.tiramiso);
        ghaza12.setImgGhaza("https://kalleh.com/book/wp-content/uploads/sites/2/2018/01/tiramisu.jpg");
        ghaza12.setNomre(2);
        ghaza12.setMojodi(true);
        ghaza12.setId_noeGhaza(8);
        ghaza12.setType("دسر");
        ghaza12.setTozih("«من را بالا بکش» یا تیرامیسو نوعی دسر ایتالیایی است که چند سالی است بین ما ایرانی\u200Cها محبوبیت زیادی پیدا کرده است و در انواع کافه\u200Cها و قنادی\u200Cها به چشم می\u200Cخورد. این دسر را اما در خانه هم می\u200Cتوان به راحتی درست کرد و از طعم آن لذت برد. اگر طعم قهوه را دوست دارید حتما تیرامیسو را امتحان و آن را به دسر محبوبتان تبدیل کنید.");
        ghaza12.setGheymat("8800");


        Ghaza ghaza13 = new Ghaza();
        ghaza13.setName("ژله");
        //ghaza13.setImgGhaza(R.drawable.jelle);
        ghaza13.setImgGhaza("https://irancook.ir/wp-content/uploads/2019/06/%DA%98%D9%84%D9%87-%D8%A8%D8%B3%D8%AA%D9%86%DB%8C-%D8%A7%D9%86%DA%AF%D9%88%D8%B1-1280x720.jpg");
        ghaza13.setNomre(4);
        ghaza13.setMojodi(true);
        ghaza13.setId_noeGhaza(8);
        ghaza13.setType("دسر");
        ghaza13.setTozih("انواع ژله ساده و تزیین شده چه با بستنی باشد چه با باقالی پلو (شما هم در میهمانی\u200Cها ژله را کنار بشقاب باقالی پلو می\u200Cریزید؟) یک دسر خوش طعم و محبوب برای تمام سنین است. در گذشته ژله را معمولا به صورت ساده و تک رنگ درست می\u200Cکردند اما حالا خانم\u200Cهای کدبانو انواع و اقسام ژله\u200Cهای چند رنگ را در لیوان، به صورت رولی و از همه هیجان\u200Cانگیزتر به صورت خرده شیشه درست می\u200Cکنند و برای انواع مراسم و جشن\u200Cها و مهمانی\u200Cها سفره را با آن رنگین می\u200Cکنند.");
        ghaza13.setGheymat("2500");

        Ghaza ghaza14 = new Ghaza();
        ghaza14.setName("قیمه");
        //ghaza14.setImgGhaza(R.drawable.gheymeh);
        ghaza14.setImgGhaza("https://www.digikala.com/mag/wp-content/uploads/2020/08/gheymeh-recipe.jpg");
        ghaza14.setNomre(5);
        ghaza14.setMojodi(true);
        ghaza14.setId_noeGhaza(7);
        ghaza14.setType("خورشتی");
        ghaza14.setTozih("خورشت قیمه معمولا به یه روش کلی و مرسوم پخته میشه، ولی چرا خورشت قیمه بعضی ها خیلی خوشمزه تر و خوش عطر تر از بقیه اس؟؟ به نظر من دلیل اصلی خوشمزه شدن قیمه تجربه داشتن در آشپزیه، اما یه دلیل دیگه هم هست که خیلی مهمه، اونم ادویه هایی که تو این خورشت استفاده میشه بعلاوه فوت و فن های پختنشه. در این مطلب علاوه بر آموزش مرحله به مرحله پخت خورشت قیمه درباره این ادویه ها و نکات هم توضیح میدم.");
        ghaza14.setGheymat("22000");


        Ghaza ghaza16 = new Ghaza();
        ghaza16.setName("نیمرو");
        //ghaza16.setImgGhaza(R.drawable.nimro);
        ghaza16.setImgGhaza("data:image/jpeg;base64,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");
        ghaza16.setNomre(4);
        ghaza16.setId_noeGhaza(6);
        ghaza16.setMojodi(true);
        ghaza16.setType("صبحانه");
        ghaza16.setTozih("با توجه به این توصیه، استفاده از تخم\u200Cمرغ عسلی یا نیمروهای نیم\u200Cپز در این دوران به\u200Cهیچ\u200Cعنوان توصیه نمی\u200Cشود. حالا اگر جزو طرفداران نیمرو هستید و نمی\u200Cدانید که چطور می\u200Cتوان از پخت کامل آن در این دوران مطمئن شد، بهتر است که موارد زیر را قبل از اقدام به پختن نیمرو در نظر بگیرید.");
        ghaza16.setGheymat("5800");


        Ghaza ghaza17 = new Ghaza();
        ghaza17.setName("هات دات");
        //ghaza17.setImgGhaza(R.drawable.hot_dog);
        ghaza17.setImgGhaza("https://irancook.ir/wp-content/uploads/2020/07/%D9%87%D8%A7%D8%AA-%D8%AF%D8%A7%DA%AF-%D8%A8%D8%A7-%D9%85%D8%AE%D9%84%D9%81%D8%A7%D8%AA-%D8%A8%DB%8C%D8%B4%D8%AA%D8%B1-1280x720.jpg");
        ghaza17.setNomre(4);
        ghaza17.setId_noeGhaza(1);
        ghaza17.setMojodi(false);
        ghaza17.setType("فست فود");
        ghaza17.setTozih("هات داگ پنیری جز غذاهای ساندویچی به شمار میره و خب با این تفسیر بچه ها عاشقش هستند. این فست فود به خاطر شکل جذاب و پنیر فراوانش محبوبیت زیادی داره. حالا اگه در کنارش سس قارچ هم باشه که دیگه هیچ کس نمی تونه ازش بگذره. میشه گفت هات داگ هم مثل تمام غذاهای فست فود ضرر داره. چون به هر حال پنیر پیتزا چربی بالایی داره. از طرفی هات داگ باید سرخ بشه. اما در کل با وجود تمام مضراتش باز بچه ها و حتی بزرگترا دوستش دارند و معمولا هر وقت قراره غذای بیرون خورده بشه قطعا هات داگ هم جز لیست هست");
        ghaza17.setGheymat("15000");

        Ghaza ghaza18 = new Ghaza();
        ghaza18.setName("میگو سوخاری");
        //ghaza18.setImgGhaza(R.drawable.meygo);
        ghaza18.setImgGhaza("https://irancook.ir/wp-content/uploads/2012/01/%D9%85%DB%8C%DA%AF%D9%88-%D8%B3%D9%88%D8%AE%D8%A7%D8%B1%DB%8C-1280x720.jpg");
        ghaza18.setNomre(3);
        ghaza18.setId_noeGhaza(4);
        ghaza18.setMojodi(true);
        ghaza18.setType("دریایی");
        ghaza18.setTozih("میگو سوخاری یکی از غذاهای دریایی بسیار خوش طعم است که خواص زیادی هم دارد. اگر میگو سوخاری رستورانی از میگو سوخاری هایی که در منزل تهیه می کنید خوشمزه تر است پس با این مطلب همراه باشید؛ چون قصد داریم میگو سوخاری رستورانی را به خانه هایتان بیاوریم. در این مطلب دو روش برای تهیه میگو سوخاری خوشمزه توضیح داده ایم: یکی از آن ها میگو سوخاری با ماءالشعیر بوده و دیگری میگو سوخاری فرانسوی. هر کدام از روش ها را که دوست داشتید، امتحان کنید و تجربیات خود را در قسمت دیدگاه ها با ما به اشتراک بگذارید. ");
        ghaza18.setGheymat("19300");


        Ghaza ghaza19 = new Ghaza();
        ghaza19.setName("پیتزا مارگاریتا");
        //ghaza19.setImgGhaza(R.drawable.pizza_margarita);
        ghaza19.setImgGhaza("https://hamyarpaz.com/allthumbs/posts/post_534/534_850_480.jpg");
        ghaza19.setNomre(3);
        ghaza19.setId_noeGhaza(2);
        ghaza19.setMojodi(true);
        ghaza19.setType("پیتزا");
        ghaza19.setTozih("پیتزای مارگاریتا یک پیتزای کلاسیک ایتالیایی با خمیر نازک هست که روی آن با پنیر موزارلا ، گوجه فرنگی و ریحان تازه پر می شود البته باید یک سس گوجه تازه هم درست کرد که مواد این سس هم گوجه فرنگی تازه ، روغن زیتون ، چند حبه سیر ، نمک و فلفل و کمی آویشن هست.\n" +
                "\n" +
                "طرز تهیه پیتزا مارگاریتا با خمیر پیتزای ایتالیایی کاملا یک وعده خوشمزه هست و تنها چیزی که در این پیتزا مهمه خمیر پیتزای ایتالیایی هست . اگه طبق این دستور پیش بروید می تونید بهترین خمیر پیتزا رو درست کنید نگران درست کردن خمیر نباشید اگه خیلی چسبناک بود کمی آرد و اگه خیلی سفت بود با کمی آب مشکل حل میشه البته وقتی میگم کمی یعنی هر بار 1 قاشق غذاخوری آب یا آرد اضافه کنید و خمیر را ورز بدین و اگه نیاز بود دوباره تکرار کنید.");
        ghaza19.setGheymat("36000");

        Ghaza ghaza20 = new Ghaza();
        ghaza20.setName("نون و پنیر");
        //ghaza20.setImgGhaza(R.drawable.noon_panit);
        ghaza20.setImgGhaza("https://kalleh.com/book/wp-content/uploads/sites/2/2019/07/cropped-noon-panir-sabzi.jpg");
        ghaza20.setNomre(5);
        ghaza20.setId_noeGhaza(6);
        ghaza20.setMojodi(true);
        ghaza20.setType("صبحانه");
        ghaza20.setTozih("نان و پنیر خوراکی است که در سفره اکثر ایرانی\u200Cها وجود دارد. معمولا این خوراک را با چاشنی\u200Cهایی مثل انگور، خرما، گردو، سبزی و خیار و گوجه، به عنوان صبحانه، عصرانه و حتی شام میل می\u200Cکنند.\n" +
                "\n" +
                "در زیر به خواص و نحوه مصرف نان و پنیر و سبزی می\u200Cپردازیم.\n" +
                "\n" +
                "خوراک نان و پنیر و سبزی دارای ویتامین\u200Cهای A و C و D و K و E و گروه ویتامین\u200Cهای B، امگا ۳، پروتئین، کلسیم، فسفر، مس، آهن، منیزیم، روی، پتاسیم، فولات، قند، کربوهیدرات و اسیدفولیک است.");
        ghaza20.setGheymat("2000");

        Ghaza ghaza21 = new Ghaza();
        ghaza21.setName("چلو ماهيچه");
        //ghaza21.setImgGhaza(R.drawable.mahiche);
        ghaza21.setImgGhaza("https://cdn.bartarinha.ir/files/fa/news/1398/12/28/2309081_818.jpg");
        ghaza21.setNomre(5);
        ghaza21.setId_noeGhaza(7);
        ghaza21.setMojodi(true);
        ghaza21.setType("خورشتی");
        ghaza21.setTozih("چلو ماهیچه یکی از غذا\u200Cهای اصیل ایرانی خاصه مهمانی\u200Cها و مناسبت\u200Cهای ویژه می\u200Cباشد. این غذای خوشمزه و اصیل ایرانی به دلیل طعم خاص و فوق العاده و مواد اولیه بسیار عالی در تهیه آن طرفداران بسیاری نیز دارد. البته طبخ چلو ماهیچه و زمان مورد نیاز برای آماده\u200Cسازی آن مشکل و زیاد می\u200Cباشد و برای ایجاد طعم خاص آن باید مهارت و فوت و فن لازمه را برای این غذا داشته باشید که البته این امر نیز با توجه به ریزه کاری\u200Cهای بیان شده در این دستور پخت و تجربه آشپزی شما قابل حل می\u200Cباشد.");
        ghaza21.setGheymat("48000");


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
        ghazas.add(ghaza10);
        ghazas.add(ghaza11);
        ghazas.add(ghaza12);
        ghazas.add(ghaza13);
        ghazas.add(ghaza14);
        ghazas.add(ghaza16);
        ghazas.add(ghaza17);
        ghazas.add(ghaza18);
        ghazas.add(ghaza19);
        ghazas.add(ghaza20);
        ghazas.add(ghaza21);
        return ghazas;

    }

    public static List<BazKhord> getComments() {
        List<BazKhord> list = new ArrayList<>();
        BazKhord bazKhord = new BazKhord();
        bazKhord.setId_ghaza(2);
        bazKhord.setId_moshtari(1);
        bazKhord.setRating(3);
        bazKhord.setMant("غذای خوبی بود اما سرد سرو شد");
        bazKhord.setTarikh(" ساعت 13:44 این باز خورد را");

        BazKhord bazKhord1 = new BazKhord();
        bazKhord1.setMant("عالی بود خدمات هم درجه یک بود");
        bazKhord1.setId_ghaza(2);
        bazKhord1.setId_moshtari(2);
        bazKhord1.setRating(4);
        bazKhord1.setTarikh(" ساعت 22:10 این باز خورد را");

        BazKhord bazKhord3 = new BazKhord();
        bazKhord3.setMant("افتضاح بود");
        bazKhord3.setId_ghaza(4);
        bazKhord3.setRating(1);
        bazKhord3.setId_moshtari(3);
        bazKhord3.setTarikh(" ساعت 22:10 این باز خورد را");

        BazKhord bazKhord2 = new BazKhord();
        bazKhord2.setMant("ممنون از غذای خوبیتون");
        bazKhord2.setId_ghaza(6);
        bazKhord2.setRating(5);
        bazKhord2.setId_moshtari(2);
        bazKhord2.setTarikh(" ساعت 16:44 این باز خورد را");


        list.add(bazKhord1);
        list.add(bazKhord2);
        list.add(bazKhord);
        list.add(bazKhord3);
        return list;
    }

    public static List<Moshtari> getMoshtaris() {
        List<Moshtari> moshtariList = new ArrayList<>();
        Moshtari moshtari = new Moshtari();
        moshtari.setName("احسان علوان زاده");
        moshtari.setShomareEshtrrak("101");
        moshtari.setShomareTel("913564875");
        moshtari.setAddress("خیابان مطهری");

        Moshtari moshtari1 = new Moshtari();
        moshtari1.setName("رامبد جوان");
        moshtari1.setShomareEshtrrak("102");
        moshtari1.setShomareTel("913233875");
        moshtari1.setAddress("خیابان معین");

        Moshtari moshtari2 = new Moshtari();
        moshtari2.setName("علی قلی زاده");
        moshtari2.setShomareEshtrrak("103");
        moshtari2.setShomareTel("913564875");
        moshtari2.setAddress("خیابان 21 متری جی");

        Moshtari moshtari3 = new Moshtari();
        moshtari3.setName("محسن تنابنده");
        moshtari3.setShomareEshtrrak("104");
        moshtari3.setShomareTel("913754875");
        moshtari3.setAddress("میدان شهران");

        Moshtari moshtari4 = new Moshtari();
        moshtari4.setName("کامیبز دیرباز");
        moshtari4.setShomareEshtrrak("105");
        moshtari4.setShomareTel("915564875");
        moshtari4.setAddress("خیابان جلفا");

        moshtariList.add(moshtari);
        moshtariList.add(moshtari1);
        moshtariList.add(moshtari2);
        moshtariList.add(moshtari3);
        moshtariList.add(moshtari4);
        return moshtariList;
    }

    public static List<Semat> getSemasts() {
        List<Semat> sematsList = new ArrayList<>();

        Semat semat = new Semat();
        semat.setName("آشپز");
        semat.setImgResource(R.drawable.ic_cheff_hat);

        Semat semat2 = new Semat();
        semat2.setName("گارسون");
        semat2.setImgResource(R.drawable.ic_food);

        Semat semat3 = new Semat();
        semat3.setName("صندوق دار");
        semat3.setImgResource(R.drawable.ic_cash_register);

        Semat semat4 = new Semat();
        semat4.setName("تاسیسات");
        semat4.setImgResource(R.drawable.ic_support);

        Semat semat5 = new Semat();
        semat5.setName("پیک");
        semat5.setImgResource(R.drawable.ic_food_delivery);

        sematsList.add(semat);
        sematsList.add(semat2);
        sematsList.add(semat3);
        sematsList.add(semat4);
        sematsList.add(semat5);
        return sematsList;
    }

    public static List<Personel> getPersonnel() {
        List<Personel> personelList = new ArrayList<>();

        Personel personel = new Personel();
        personel.setName("علی اصغری");
        personel.setAddress("شیراز");
        personel.setId_semat(1);
        personel.setShomareTel("0315475213");
        personel.setTarikhVorol("1396/10/10");

        Personel personel1 = new Personel();
        personel1.setName("محسن شریعتی");
        personel1.setAddress("تهران");
        personel1.setId_semat(1);
        personel1.setShomareTel("09631476523");
        personel1.setTarikhVorol("1398/10/10");

        Personel personel2 = new Personel();
        personel2.setName("رضا بلبلی");
        personel2.setId_semat(5);
        personel2.setAddress("تهران");
        personel2.setShomareTel("09135874269");
        personel2.setTarikhVorol("1397/05/10");

        Personel personel3 = new Personel();
        personel3.setName("سارا خادمی");
        personel3.setId_semat(3);
        personel3.setAddress("تهران");
        personel3.setShomareTel("0963147852");
        personel3.setTarikhVorol("1398/11/29");

        Personel personel4 = new Personel();
        personel4.setName("خسرو نژادمهدی");
        personel4.setId_semat(2);
        personel4.setAddress("تهران");
        personel4.setShomareTel("09165478932");
        personel4.setTarikhVorol("1396/10/10");

        personelList.add(personel);
        personelList.add(personel1);
        personelList.add(personel2);
        personelList.add(personel3);
        personelList.add(personel4);
        return personelList;

    }

}
