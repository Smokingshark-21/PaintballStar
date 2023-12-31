package de.syntax_institut.myapplication.data

import de.syntax_institut.myapplication.R
import de.syntax_institut.myapplication.data.model.item

class Datasource {
    fun loaddata():MutableList<item>{
        return  mutableListOf<item>(
            item(R.string.maker1, R.drawable.rap4_468_grande),
            item(R.string.maker2, R.drawable.emekpaket),
            item(R.string.maker3,R.drawable.carmatech_sar12_paintball_markierer_front_20154_750x750),
            item(R.string.maker4, R.drawable.t15_cerakote_10),
            item(R.string.maker5, R.drawable.img_0029_holz),
            item(R.string.maker6, R.drawable.img_0036),
            item(R.string.maker7, R.drawable.first_strike_dmr__93334),
            item(R.string.maker8,R.drawable.granaty_i_granatniki_asg_replika_granatnika_m79_real_wood_king_arms_579377_1_),
            item(R.string.maker9, R.drawable.download__2_),
            item(R.string.maker10, R.drawable.hdb68)
        )
    }
}