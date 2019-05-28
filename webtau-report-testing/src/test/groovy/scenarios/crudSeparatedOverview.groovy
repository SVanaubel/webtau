package scenarios

import static com.twosigma.webtau.WebTauGroovyDsl.*
import static pages.Pages.*

scenario('summary view') {
    report.open('webtau-report-crud-separated-missing-method.html')
    browser.doc.capture('report-summary')
}

scenario('customer update test summary') {
    report.selectTest('customer update')
    browser.doc.capture('report-test-summary')
}

scenario('customer update http calls') {
    report.open('webtau-report-crud-separated.html')
    report.selectTest('customer update')

    report.selectHttpCalls()
    report.expandHttpCall(2)

    browser.doc.withAnnotations(
            browser.doc.highlighter(report.fullScreenIcon),
            browser.doc.highlighter(report.collapsedHeader))
            .capture('report-crud-separated-http-calls')
}