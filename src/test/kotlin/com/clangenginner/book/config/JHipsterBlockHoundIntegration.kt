package com.clangenginner.book.config

import reactor.blockhound.BlockHound
import reactor.blockhound.integration.BlockHoundIntegration

class JHipsterBlockHoundIntegration : BlockHoundIntegration {
    override fun applyTo(builder: BlockHound.Builder) {
        // Workaround until https://github.com/reactor/reactor-core/issues/2137 is fixed
        builder.allowBlockingCallsInside("reactor.core.scheduler.BoundedElasticScheduler\$BoundedState", "dispose")
        builder.allowBlockingCallsInside("reactor.core.scheduler.BoundedElasticScheduler", "schedule")
        builder.allowBlockingCallsInside("org.springframework.validation.beanvalidation.SpringValidatorAdapter", "validate")
        builder.allowBlockingCallsInside("com.clangenginner.book.service.MailService", "sendEmailFromTemplate")
        builder.allowBlockingCallsInside("com.clangenginner.book.security.DomainUserDetailsService", "createSpringSecurityUser")
    }
}
