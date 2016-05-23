
export default class AddOfferController {
    constructor(offersService, usersService) {
        this.offersService = offersService;
        this.usersService = usersService;
    }



    /*createSchedule(schedule) {
        var result = [];
        for(var sch in schedule){
            var term = schedule[sch];
            let scheduleData = {
                day: term.day,
                start: term.start,
                end: term.end,
                teacher: term.teacher,
                label: term.day+' '+term.start+'-'+term.end+' '+term.teacher+' '+term.subject
            }
            result.push(scheduleData);
        }
        return result;
    }*/
}
