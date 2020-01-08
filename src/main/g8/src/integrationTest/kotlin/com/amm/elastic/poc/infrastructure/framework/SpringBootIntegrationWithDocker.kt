package com.amm.elastic.poc.infrastructure.framework

import org.junit.ClassRule
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.testcontainers.containers.DockerComposeContainer
import org.testcontainers.containers.wait.strategy.Wait
import java.io.File

class KotlinDockerComposeContainer(vararg files: File) : DockerComposeContainer<KotlinDockerComposeContainer>(*files)

@ActiveProfiles("integration-test")
@SpringBootTest(classes = [Application::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@ExtendWith(SpringExtension::class)
abstract class SpringBootIntegrationWithDocker {

    companion object {
        @ClassRule
        @JvmField
        val docker: Unit = KotlinDockerComposeContainer(File("docker-compose-test.yml"))
            .withLocalCompose(true)
            //.waitingFor("postgresql", Wait.defaultWaitStrategy())
            //.waitingFor("kafka", Wait.defaultWaitStrategy())
            .start()
    }
}
