
(function($){$(document).ready(function(){
    $('.range input[type="range"]').on("change mousemove", function() {
        $(this).next().html($(this).val());
    });
});})(jQuery);