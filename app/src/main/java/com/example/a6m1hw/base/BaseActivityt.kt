import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

import com.example.a6m1hw.R

abstract class BaseActivityt<VB: ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: VB
    abstract fun inflateViewBinding(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    open fun initView() {}
}