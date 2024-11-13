package no.nrk.tv.type

enum class ChannelType {
    NRK1, NRK2, NRK3, UNKNOWN;

    companion object {
        infix fun from(value: String): ChannelType = entries.firstOrNull { it.name == value.uppercase() } ?: UNKNOWN
    }
}