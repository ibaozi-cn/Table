package one.hundred.table

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout
import one.hundred.table.life.LifecycleDemoActivity
import org.jetbrains.anko.button
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.linearLayout

class MainHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        linearLayout {
            orientation = LinearLayout.VERTICAL

            button("高版本栗子") {
                setOnClickListener {
                    startActivity(intentFor<LifecycleDemoActivity>())
                }
            }
        }
    }
}
