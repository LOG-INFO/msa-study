package info.log.event

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.net.InetAddress
import java.net.UnknownHostException


@Component
class ServiceAddressUtil(
    @Value("\${server.port}") private val port: String,
    private var serviceAddress: String? = null,
){

    fun getServiceAddress(): String? {
        if (serviceAddress == null) {
            serviceAddress = findMyHostname() + "/" + findMyIpAddress() + ":" + port
        }
        return serviceAddress
    }

    private fun findMyHostname(): String {
        return try {
            InetAddress.getLocalHost().getHostName()
        } catch (e: UnknownHostException) {
            "unknown host name"
        }
    }

    private fun findMyIpAddress(): String {
        return try {
            InetAddress.getLocalHost().getHostAddress()
        } catch (e: UnknownHostException) {
            "unknown IP address"
        }
    }

}