package org.pbreakers.web.jetpackarchitecture.webcontroller

import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

@Controller
class ParentController {

    @GetMapping(value = "/")
    fun home(@RequestParam(defaultValue = "World") name: String, modelMap: ModelMap): String {
        modelMap["name"] = name
        return "index"
    }
}