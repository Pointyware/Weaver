
package org.pointyware.weaver.example

import org.pointyware.weaver.dsl.ProgramOutput.PrintOutput
import org.pointyware.weaver.dsl.site
import org.pointyware.weaver.home.homePage
import org.pointyware.weaver.utils.ProgramInputs
import org.pointyware.weaver.utils.consumeArgs

/**
 * How to use:
 * --out <filepath> | the default is System.out with a virtual root at "/"
 *
 */
fun main(vararg args: String) {
    // Declare Program defaults explicitly for parity with documentation 👍
    var inputs = ProgramInputs(
        output = PrintOutput("/", System.out)
    )

    // Process Arguments
    inputs = args.iterator().consumeArgs(inputs)

    // no setup needed, just call the site function
    site(inputs.output) {
        homePage()
        file("docs/privacy-policy.html", "privacy-policy/index.html")
        file("robots.txt")
    }
}
