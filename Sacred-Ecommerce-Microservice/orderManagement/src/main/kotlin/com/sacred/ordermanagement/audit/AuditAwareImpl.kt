package com.sacred.ordermanagement.audit

import org.springframework.data.domain.AuditorAware
import org.springframework.stereotype.Component
import java.util.Optional

@Component("auditAwareImpl")
class AuditAwareImpl: AuditorAware<String>{
    override fun getCurrentAuditor(): Optional<String> {
        return Optional.of("ORDER_MGMT_MS")
    }
}