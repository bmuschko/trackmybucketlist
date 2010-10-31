import com.google.appengine.api.datastore.Query
import com.google.appengine.api.datastore.PreparedQuery
import static com.google.appengine.api.datastore.FetchOptions.Builder.*

log.info "Getting all goals"

def query = new Query("Goal")
PreparedQuery preparedQuery = datastore.prepare(query)
query.addSort("created", Query.SortDirection.DESCENDING)
def goals = preparedQuery.asList(withDefaults())

request.goals = goals

forward '/WEB-INF/pages/goals.gtpl'
