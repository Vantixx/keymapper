package com.example.keymapper

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.view.InputDevice
import android.view.MotionEvent


class KeymapperService : AccessibilityService() {

    // إعدادات الحساسية وثبات التصويب (Aim Smoothing & Sensitivity)
    private var sensitivity: Float = 1.2f
    private var smoothingFactor: Float = 0.5f // خوارزمية تنعيم الحركة لمنع الاهتزاز
    private var lastX: Float = 0f
    private var lastY: Float = 0f

    override fun onServiceConnected() {
        super.onServiceConnected()
        // تم تفعيل خدمة التحكم بالماوس والكيبورد بنجاح
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // متابعة أحداث نظام الأندرويد
    }

    override fun onInterrupt() {
        // إيقاف الخدمة عند الحاجة
    }

    // معالجة حركة الماوس للوصول إلى دقة وثبات عالي في الـ Aim
    fun processMouseMovement(rawX: Float, rawY: Float): Pair<Float, Float> {
        // خوارزمية التنعيم لتفادي تقطيع الحركة (Micro-adjustments smooth)
        val smoothedX = lastX + (rawX - lastX) * smoothingFactor
        val smoothedY = lastY + (rawY - lastY) * smoothingFactor

        lastX = smoothedX
        lastY = smoothedY

        // تطبيق معامل الحساسية
        return Pair(smoothedX * sensitivity, smoothedY * sensitivity)
    }
}