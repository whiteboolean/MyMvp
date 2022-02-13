package com.example.mymvp

import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.mymvp.databinding.ActivityMainBinding
import com.example.mymvp.databinding.ItemGoodsBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<Goods>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list = mutableListOf()
        getData()
        binding.rcv.addItemDecoration(DividerItemDecoration(this,LinearLayout.VERTICAL))
        binding.rcv.adapter =
            object : BaseQuickAdapter<Goods, BaseViewHolder>(R.layout.item_goods, list) {
                override fun convert(holder: BaseViewHolder, item: Goods) {
                    val imageView = holder.getView<ImageView>(R.id.imageView)
                    val title = holder.getView<TextView>(R.id.textViewPersonName)
                    val subTitle = holder.getView<TextView>(R.id.textView)
                    imageView.setImageResource(item.image)
                    title.text = item.context
                    subTitle.text = item.subTitle
                }

            }
    }

    private fun getData() {
        val goods1 = Goods(R.mipmap.ic_launcher, "1", "111")
        val goods2 = Goods(R.mipmap.ic_launcher, "2", "222")
        val goods3 = Goods(R.mipmap.ic_launcher, "3", "333")
        val goods4 = Goods(R.mipmap.ic_launcher, "4", "444")
        val goods5 = Goods(R.mipmap.ic_launcher, "5", "555")
        val goods6 = Goods(R.mipmap.ic_launcher, "6", "666")
        val goods7 = Goods(R.mipmap.ic_launcher, "7", "777")
        val goods8 = Goods(R.mipmap.ic_launcher, "8", "888")
        list.apply {
            add(goods1)
            add(goods2)
            add(goods3)
            add(goods4)
            add(goods5)
            add(goods6)
            add(goods7)
            add(goods8)
            add(goods1)
        }
    }
}