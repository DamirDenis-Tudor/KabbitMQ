package io.github.damir.denis.tudor.ktor.server.rabbitmq.service

import io.ktor.server.config.*

/**
 * Configuration class for RabbitMQ settings.
 * This class loads configuration values for RabbitMQ URI and connection name from the provided Ktor application config.
 *
 * @param config the Ktor `ApplicationConfig` used to load configuration values.
 *
 * @author Damir Denis-Tudor
 * @version 0.1.0
 */
class KabbitMQConfig(config: ApplicationConfig) {
    companion object{
        lateinit var service: KabbitMQService
    }
    var uri: String = config.tryGetString("uri") ?: "amqp://guest:guest@localhost:5672"
    var defaultConnectionName: String = config.tryGetString("defaultConnectionName") ?: "default_connection"
    var connectionAttempts: Int = config.tryGetString("connectionAttempts")?.toInt() ?: 10
    var attemptDelay: Int = config.tryGetString("attemptDelay")?.toInt() ?: 5

    var tlsEnabled: Boolean = config.tryGetString("tls.enabled")?.toBoolean() == true
    var tlsKeystorePath: String = config.tryGetString("tls.keystorePath") ?: ""
    var tlsKeystorePassword: String = config.tryGetString("tls.keystorePassword") ?: ""
    var tlsTruststorePath: String = config.tryGetString("tls.truststorePath") ?: ""
    var tlsTruststorePassword: String = config.tryGetString("tls.truststorePassword") ?: ""
}
