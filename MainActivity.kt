package com.example.keymapper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // إعدادات واجهة التحكم بالـ Aim والسرعة
    private var currentPollingRate: Int = 1000 // معدل استجابة الماوس (125Hz - 1000Hz)
    private var aimSensitivity: Float = 1.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // هنا يتم تحميل واجهة التحكم الخاصة بالتطبيق
    }

    // دالة لتغيير الـ Polling Rate للحصول على أسرع استجابة بدون تأخير
    fun setPollingRate(rateHz: Int) {
        this.currentPollingRate = rateHz
    }

    // دالة لضبط حساسية الـ Aim وثباته
    fun setAimSensitivity(sens: Float) {
        this.aimSensitivity = sens
    }
}