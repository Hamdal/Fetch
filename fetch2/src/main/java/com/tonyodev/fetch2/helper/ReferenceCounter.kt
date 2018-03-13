package com.tonyodev.fetch2.helper

class ReferenceCounter<out T>(val data: T) {

    @Volatile
    private var count = 0

    fun getReferenceCount(): Int {
        return synchronized(count) {
            count
        }
    }

    fun incrementReferenceCount(): Int {
        return synchronized(count) {
            count += 1
            count
        }
    }

    fun decrementReferenceCount(): Int {
        return synchronized(count) {
            if (count > 0) {
                count -= 1
            }
            count
        }
    }

}