import com.google.appengine.api.datastore.Entity

log.info "Inserting goal"

def goal = new Entity("Goal")
goal.name = params.name
goal.description = params.description
goal.userId = request.userInfo.userId
goal.created = new Date()
goal.save()

redirect '/user/goals'