package org.feeshop.shopfee

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform