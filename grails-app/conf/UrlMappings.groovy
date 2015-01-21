class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

//        "/projects" {
//            controller = "project"
//            action = "all"
//        }
//
//        "/project/new" {
//            controller = "project"
//            action = "create"
//        }
//        "/project/save" {
//            controller = "project"
//            action = "save"
//        }
//
//        "/project/$id" {
//            controller = "project"
//            action = "view"
//        }


        "/"(view:"/index")
        "500"(view:'/error')
	}
}
