package com.example.mymvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.mymvp.databinding.ActivityMainBinding
import com.example.mymvp.presenter.BasePresenter
import com.example.mymvp.presenter.GoodsPresenter
import com.example.mymvp.view.IBaseView
import com.example.mymvp.view.IGoodsView

/**
 * 核心思想： 相对于MVC来说，把原来的UI逻辑抽象成VIEW接口，把原来的业务逻辑抽象成PRESENTER接口，
 * MODEL还是原来的MODEL
 */
class MainActivity : BaseActivity<GoodsPresenter<IGoodsView>, IGoodsView>(), IGoodsView {

    lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<Goods>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        lifecycle.addObserver(presenter)
        setContentView(binding.root)
        list = mutableListOf()
        presenter.attach(this)
        presenter.fetch()
    }

    override fun showGoodView(good: MutableList<Goods>) {
        binding.rcv.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
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

    override fun showLoading(msg: String) {
    }

    override fun dismissLoading() {
    }

    override fun showErrorMessage(msg: String) {
        Toast.makeText(this, "出错了", Toast.LENGTH_SHORT).show()
    }

    override fun createPresenter(): GoodsPresenter<IGoodsView> {
        return GoodsPresenter<IGoodsView>()
    }


}