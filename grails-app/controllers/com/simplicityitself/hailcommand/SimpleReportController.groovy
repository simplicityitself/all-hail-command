package com.simplicityitself.hailcommand

import grails.converters.JSON

class SimpleReportController {

  def index(SimpleCountryReportCommand reportCommand) {
    [report: reportCommand()]
  }

  def json(SimpleCountryReportCommand reportCommand) {
    if (!reportCommand.validate()) {
      render [message: "Failed validation"] as JSON
    }
    render reportCommand() as JSON
  }

  def xml(SimpleCountryReportCommand reportCommand) {
    render(contentType: "text/xml") {
      countries {
        for (c in reportCommand().countries) {
          "countryMatch"(name: c.name, code: c.currency, tld:c.tld)
        }
      }
    }
  }
}
