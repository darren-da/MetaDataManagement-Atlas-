declare module ZoomCharts.Configuration {
    /* tslint:disable */

    export interface IGeoRectangle {
        east: number;
        north: number;
        south: number;
        west: number;
    }
    export interface BaseApi {
        /** Adds specific data and updates the chart.  */
        addData(data: any, sourceId?: string): any;
        /** 
        @deprecated use settings.parentChart instead. */
        addSubchartContainer(container: HTMLElement): void;
        back(): BaseApi;
        clearHistory(): BaseApi;
        customize(name: any): BaseApi;
        export(type: any, dimensions: any, transparent: any): void;
        /** returns data uri string  */
        exportGetDimensions(dimensions: any): {
                width: number;
                height: number;
                scale: number;
                chartWidth: number;
                chartHeight: number;
            };
        exportImageAsString(type: any, dimensions: any, transparent: any): string;
        exportImageGetDimensions(dimensions: any): {
                width: number;
                height: number;
                scale: number;
                chartWidth: number;
                chartHeight: number;
            };
        fullscreen(isFullscreen: boolean): boolean;
        hideMenu(): BaseApi;
        home(): boolean;
        off(name: any, listener: any): boolean;
        /** Adds event listener.
        Supported event types: "timeChange", "selectionChange, "click", "doubleClick".
        Consult doc for event types in specific SDK  */
        on(name: any, listener: any): any;
        /** Does immediate repaint. Use to sync updates between multiple charts.  */
        paintNow(force?: boolean): BaseApi;
        profiler(): BaseProfiler;
        /** Clears data cache and loads new data. The time range is preserved.  */
        reloadData(sourceId?: string): any;
        /** Removes chart from DOM. Is automatically called when you create a new Chart with the same container.  */
        remove(): void;
        /** Removes data and updates the chart.  */
        removeData(data: any, sourceId?: string): void;
        /** Removes data and updates the chart.  */
        replaceData(data: any, sourceId?: string): any;
        restoreState(state: any, animate?: boolean): void;
        /** returns data uri string  */
        saveAsImage(type: any, dimensions: any, transparent: any): string;
        saveState(): string;
        typeName: string;
        /** Re-evaluate data filters on next paint. */
        updateFilters(): void;
        /** Updates the chart settings. Only the settings that have to be changed should be passed.  */
        updateSettings(changes?: BaseSettings): BaseApi;
        /** Call when the container size has been changed to update the chart.  */
        updateSize(): BaseApi;
        /** Re-evaluate style for all objects on next paint. */
        updateStyle(): void;
    }
    export interface BaseDataErrorResponse {
        error?: string;
    }
    export interface BaseLabel {
        align: string;
        angle: number;
        aspectRatio: number;
        backgroundStyle: BaseSettingsBackgroundStyle;
        borderRadius: number;
        /** current position, canvas coordinates  */
        curX: number;
        /** current position, canvas coordinates  */
        curY: number;
        hheight: number;
        hwidth: number;
        /** internal stuff  */
        id: any;
        image: any;
        imageSlicing: [number, number, number, number];
        lineHeight: number;
        /** with line spacing  */
        lineHeightM: number;
        lineSpacing: number;
        loadedImage: any;
        margin: number;
        maxWidth: any;
        measureDone: boolean;
        onClick: any;
        onHover: any;
        padding: number;
        px: any;
        py: any;
        rows: any;
        scaleWithSize: boolean;
        scaleWithZoom: boolean;
        shouldBeVisible: boolean;
        text: string;
        textStyle: BaseSettingsTextStyle;
        url: any;
        userPlaced: boolean;
        visible: boolean;
        /** per label specific use  */
        x: any;
        /** per label specific use  */
        y: any;
    }
    export interface BaseProfiler {
        framesCount: number;
        hasPendingRequests(): boolean;
        measureFps(measureFpsIters: any, measureFpsCallback: () => void): boolean;
    }
    /** Base settings including multiple configurations around overall chart appearance, interaction and rendering. */
    export interface BaseSettings {
        advanced?: BaseSettingsAdvanced;
        /** Chart area related settings. */
        area?: BaseSettingsArea;
        assetsUrlBase?: string;
        /** Element of the page where the chart will be inserted. For example a div. Any contents of the element will be cleared.
        Note that a single element can host only one chart.  */
        container?: (string|HTMLElement);
        credits?: BaseSettingsCredits;
        data?: Array<BaseSettingsData>;
        /** The events used to handle user interaction with UI elements. See see::interactivity/::events:: for more info. */
        events?: BaseSettingsEvents;
        /** Customise chart resize handles or animation duration settings. */
        interaction?: BaseSettingsInteraction;
        legend?: BaseSettingsLegend;
        /** Localizeable strings including export type options and useful default buttons used for chart interaction.
        Buttons like to navigate back, set the chart on full screen and others. */
        localization?: BaseSettingsLocalization;
        /** Parent chart to place this chart as subchart.
        Use area.left, area.top, area.width, area.height to position the subchart within parent chart. */
        parentChart?: BaseApi;
        /** Theme to apply. Should contain an javascript object with additional settings.  */
        theme?: BaseSettings;
        /** The chart's main title. */
        title?: BaseSettingsTitle;
        /** Adjustable settings to manage default and custom toolbar items, as well as toolbar overall appearance. */
        toolbar?: BaseSettingsToolbar;
    }
    export interface BaseSettingsAdvanced {
        /** List of assets to load from assets directory. This should be used to load CSS files. */
        assets?: Array<string>;
        builtinAssets?: Dictionary<string>;
        /** URL for export proxy requests. */
        exportProxyURL?: string;
        /** Enables high resolution rendering on high DPI screens. As performance is varied across different browsers, disable this to
        improve the performance of your application.  */
        highDPI?: boolean;
        /** Whether to store entire label into bitmap. Use it to improve the performance of your application.  */
        labelCache?: boolean;
        /** Whether to show verbose logging.  */
        logging?: boolean;
        /** Maximum height of canvas object. The canvas will be stretched if chart is bigger that this. Note that increasing beyond 2048
        is known to cause loss of hardware acceleration on Safari/OSX. */
        maxCanvasHeight?: number;
        /** Maximum width of canvas object. The canvas will be stretched if chart is bigger that this. Note that increasing beyond 2048
        is known to cause loss of hardware acceleration on Safari/OSX. */
        maxCanvasWidth?: number;
        /** Extra assets to be loaded for pdfExport action. */
        pdfExportAssets?: Array<string>;
        /** Pointer related settings. */
        pointer?: BaseSettingsAdvancedPointer;
        /** Whether to show frames per second on the chart.  */
        showFPS?: boolean;
        /** Whether to show the current timestamp on the chart. Use only for debugging.  */
        showTimestamp?: boolean;
        /** Whether to use debugging option to paint pointer trails on screen.  */
        showTouches?: boolean;
        /** Miscellaneous style settings.  */
        style?: BaseSettingsAdvancedStyle;
        /** CSS class for current theme. Used to reference chart container in CSS files.  */
        themeCSSClass?: string;
        /** Whether to use requestAnimationFrame for requested paint instead of setTimeout.  */
        useAnimationFrame?: boolean;
    }
    export interface BaseSettingsAdvancedPointer {
        /** Pixels pointer can move around and still register as double click. */
        doubleClickSensitivity?: number;
        /** Time between clicks to register as double click. */
        doubleClickTimeout?: number;
        /** Pixels to move pointer before dragging starts. */
        dragSensitivity?: number;
        /** Time in ms for long press. */
        longPressTimeout?: number;
        /** If enabled, normal click event is not sent when user performs a double click. A not so nice side effect is that any on click
        actions are delayed by the double click timeout. Set to false if you are not relying on double click events.  */
        noClickOnDoubleClick?: boolean;
        /** Time window to use for pointer speed estimation. */
        speedAveragingPeriod?: number;
    }
    export interface BaseSettingsAdvancedStyle {
        /** Loading arc animation style  */
        loadingArcStyle?: {
            lineColor?: string;
            lineWidth?: number;
            /** Specifies the location of the loading indicator. */
            location?: string;
            /** Loading arc radius. */
            r?: number;
        };
        /** Message text  */
        messageTextStyle?: {
            fillColor?: string;
            font?: string;
        };
    }
    export interface BaseSettingsArea {
        /** Height of the chart. If undefined the chart height will adapt to container element. */
        height?: number;
        left?: number;
        /** The maximum chart height. Chart will not resize below this. */
        maxHeight?: number;
        /** The maximum chart width. The chart will not resize below this */
        maxWidth?: number;
        /** The minimum chart height. Chart will not resize below this. */
        minHeight?: number;
        /** The minimum chart width. The chart will not resize below this */
        minWidth?: number;
        /** Area style.  */
        style?: BaseSettingsAreaStyle;
        top?: number;
        /** Width of the chart. If undefined the chart width will adapt to container element. */
        width?: number;
    }
    export interface BaseSettingsAreaStyle {
        /** Background fill color of chart area */
        fillColor?: string;
        /** Background image of  chart area. */
        image?: string;
        overlayColor?: string;
    }
    export interface BaseSettingsBackgroundStyle {
        fillColor?: string;
        lineColor?: string;
        lineDash?: Array<number>;
        lineWidth?: number;
        shadowBlur?: number;
        shadowColor?: string;
        shadowOffsetX?: number;
        shadowOffsetY?: number;
    }
    export interface BaseSettingsCredits {
        /** Enable/disable chart credits. Note that it does not affect exported image.  */
        enabled?: boolean;
        /** Whether to render credits on the exported image. Note that it does not affect chart.  */
        enabledOnExport?: boolean;
        /** URL of credits image. */
        image?: string;
        /** Image scaling. Use to embed higher resolution images. */
        imageScaling?: number;
        /** Credits location */
        location?: string;
        /** URL to open on click. */
        url?: string;
    }
    export interface BaseSettingsData {
        /** Data loading format. Currently only JSON supported. */
        format?: string;
        /** Data id used for series to reference specific data source.  */
        id?: string;
        /** Max number of parallel data requests to issue. More requests will result in faster loading, but might put heavy load on server. */
        numberOfParallelRequests?: number;
        /** Delegate that can be used to process data returned by the server for the HTTP request issued by the chart. */
        postprocessorFunction?: (
            /** The raw data received from the server.  */
            data: any) => any;
        /** Provides the ability to embed chart data directly into the chart configuration.
        Data can be represented by an JavaScript object or a JSON string.  */
        preloaded?: (string|BaseDataErrorResponse);
        /** Timeout in milliseconds for data requests. This timeout only applies to HTTP requests issued by the chart directly. */
        requestTimeout?: number;
        /** URL to load more data. URL parameters: from, to, unit */
        url?: string;
        /** List of extra parameters to pass with data URL.  */
        urlParameters?: Array<{
                /** Parameter name. */
                name?: string;
                /** Parameter value. */
                value?: string;
            }>;
    }
    export interface BaseSettingsEvents {
        /** Time to wait after last action before firing onChartUpdate event. */
        chartUpdateDelay?: number;
        /** Function called when chart scrolling animation is finished.  */
        onAnimationDone?: (
            /** Event object attached to event listener */
            event: any) => void;
        /** Function called when whenever current view has changed. Usually after panning and navigation. Use to update any linked views.
        Note that this is also fired after chart initialization and API methods. Use event.origin field to determine event's origin.  */
        onChartUpdate?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when user clicks on chart.  */
        onClick?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when user double clicks on chart.  */
        onDoubleClick?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when error occurs, default behavior is log to console.  */
        onError?: (
            /** error message  */
            message: any) => void;
        /** Function called when object pointer is on changes.  */
        onHoverChange?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called whenever chart placement on screen changes. Note that this is called on every animation frame and is intended
        for painting overlays only.  */
        onPositionChange?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when user right clicks on chart.  */
        onRightClick?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when selected slices has changed.  */
        onSelectionChange?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when settings are changed.  */
        onSettingsChange?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when user triple clicks on chart. Use it for custom function call.  */
        onTripleClick?: (
            /** Event object attached to event listener  */
            event: any) => void;
    }
    export interface BaseSettingsInteraction {
        /** Chart animation settings. */
        animation?: {
            /** Duration of hover animation. */
            hoverDuration?: number;
            /** Duration of scroll animation. */
            scrollDuration?: number;
        };
        resizing?: BaseSettingsResizer;
    }
    export interface BaseSettingsLabelStyle {
        /** Text alignment. */
        align?: string;
        /** The angle at which the label are rotated */
        angle?: number;
        /** Ratio between label sizes in different dimensions */
        aspectRatio?: number;
        /** Background style including fill color.  */
        backgroundStyle?: BaseSettingsBackgroundStyle;
        /** Radius of item border. Similar to CSS border radius property. Zero radius will show a rectangle */
        borderRadius?: number;
        /** Label image. */
        image?: string;
        /** Slicing to use tiled images. Array of 4 values: [left, top, width, height]  */
        imageSlicing?: [number, number, number, number];
        /** Vertical space between the lines of text. In multiples of text line height. */
        lineSpacing?: number;
        /** Margin around label text */
        margin?: number;
        /** Maximum width of the label. */
        maxWidth?: number;
        /** Padding between item content and item border. */
        padding?: number;
        /** Label text.  */
        text?: string;
        /** Text style including fill color and font.  */
        textStyle?: BaseSettingsTextStyle;
    }
    export interface BaseSettingsLegend {
        /** Settings to configure the legend marker appearance if disabled series corresponded. */
        advanced?: {
            /** Style for legend entry in case when disabled series presented.  */
            disabledSeries?: {
                fillColor?: string;
                lineColor?: string;
                textColor?: string;
            };
            /** Background color for selected legend entry. */
            selectedBackground?: string;
            /** Border color for selected legend entry. */
            selectedBorder?: string;
        };
        /** Show/hide chart legend.  */
        enabled?: boolean;
        /** Whether to order entries to get possibly equal number of items into columns or rows. If false, once the row or column is full of entries,
        the next element will be first in the new row or column/rows.  */
        equalizeRowsColumns?: boolean;
        /** Maximum height of the legend. If null, all available vertical space of chart will be consumed to set as much entries as possible.
        It coincides with the chart height if legend panel side is on a left or right. */
        height?: number;
        /** Vertical space between the lines of text. */
        lineSpacing?: number;
        /** Margin around each legend entry. */
        margin?: number;
        /** Visual element of legend entry with appropriate style to a slice color it corresponds. The content of each legend marker is the
        same as info popup appearing while hovering on slice.  */
        marker?: BaseSettingsLegendMarker;
        /** Max number of symbols used in one line of text that applies to any legend entry. */
        maxLineSymbols?: number;
        /** Max number of columns. Use in conjunction with side parameter under the legend panel should be right or left in order to arrange entries by columns. */
        numberOfColumns?: number;
        /** Max number of rows. Use in conjunction with side parameter under the legend panel that should be set as bottom or top in order to arrange entries by rows. */
        numberOfRows?: number;
        /** Padding around each entry text and marker. */
        padding?: number;
        /** Legend enclosing panel settings.  */
        panel?: BaseSettingsLegendPanel;
        /** Text settings displaying in legend entries.  */
        text?: {
            fillColor?: string;
            font?: string;
        };
        /** Maximum width of the legend. If null, all available horizontal space of chart will be consumed to set as much entries as possible.
        It coincides with the chart width if legend panel side is on a top or bottom. */
        width?: number;
    }
    export interface BaseSettingsLegendMarker {
        /** Marker position relative to text */
        alignment?: string;
        /** Line color around marker shape */
        lineColor?: string;
        /** Marker size. */
        size?: number;
    }
    export interface BaseSettingsLegendPanel {
        /** Panel alignment */
        align?: string;
        /** Whether allow packing over other panels  */
        floating?: boolean;
        location?: string;
        /** Margin around the panel */
        margin?: number;
        padding?: number;
        /** Panel side */
        side?: string;
    }
    export interface BaseSettingsLineStyle {
        lineColor?: string;
        lineDash?: Array<number>;
        lineWidth?: number;
    }
    export interface BaseSettingsLocalization {
        /** Text used on menu close button.  */
        closeButton?: string;
        /** Error message when data request has failed.  */
        dataRequestFailed?: string;
        /** Message to show when data loading is in progress.  */
        loadingLabel?: string;
        /** Strings used in toolbars.  */
        toolbar?: BaseSettingsLocalizationToolbar;
    }
    export interface BaseSettingsLocalizationToolbar {
        backButton?: string;
        backTitle?: string;
        exportButton?: string;
        exportCSV?: string;
        exportJpeg?: string;
        exportPDF?: string;
        exportPNG?: string;
        exportTitle?: string;
        exportXLS?: string;
        fullscreenButton?: string;
        fullscreenTitle?: string;
        zoomoutButton?: string;
        zoomoutTitle?: string;
    }
    export interface BaseSettingsResizer {
        /** Enable/disable chart resizing.  */
        enabled?: boolean;
        /** Whether to fix chart aspect ratio while resizing.  */
        fixedAspect?: boolean;
        /** Distance from chart edge that will be used for resizing. */
        grabDistance?: number;
        /** Max pointer distance from chart edge when resize handle appears. */
        visibilityDistance?: number;
    }
    export interface BaseSettingsTextStyle {
        fillColor?: string;
        font?: string;
        shadowBlur?: number;
        shadowColor?: string;
        shadowOffsetX?: number;
        shadowOffsetY?: number;
    }
    export interface BaseSettingsTitle {
        /** Alignment of the title text. */
        align?: string;
        /** Show/hide chart title  */
        enabled?: boolean;
        /** Whether to display title on the exported image. Note that it does not affect chart.  */
        enabledOnExport?: boolean;
        /** Margin around title text, in px. */
        margin?: number;
        /** Title style  */
        style?: {
            fillColor?: string;
            font?: string;
        };
        /** Title text.  */
        text?: string;
    }
    export interface BaseSettingsToolbar {
        /** Toolbar align. Note that it can be overridden for individual items using item.align. Also Use 'top' or 'bottom' 
        sides in conjunction with 'left', 'right' align or use 'left', 'right' sides with 'top', 'bottom'. */
        align?: string;
        /** Whether to show back button in toolbar.  */
        back?: boolean;
        /** CSS class name for the toolbar HTML panel.  */
        cssClass?: string;
        /** Show/hide toolbar.  */
        enabled?: boolean;
        /** Whether to show export dropdown in toolbar.  */
        export?: boolean;
        /** A list of user defined items to show in toolbar.  */
        extraItems?: Array<(string|BaseSettingsToolbarItem)>;
        /** A list of toolbar items. Use it to completely override the items in toolbar.  */
        items?: Array<(string|BaseSettingsToolbarItem)>;
        /** Toolbar location inside chart. */
        location?: string;
        /** Whether to show or hide labels next to toolbar items by default. Note that it can be overridden for individual items using item.showLabels.  */
        showLabels?: boolean;
        /** Toolbar placement side. Note that it can be overridden for individual items using item.side. */
        side?: string;
        /** Whether to show the zoom out button.  */
        zoomOut?: boolean;
    }
    export interface BaseSettingsToolbarItem {
        /** Item align. */
        align?: string;
        /** CSS class name.  */
        cssClass?: string;
        /** Item image, URL to image. */
        image?: string;
        /** Built in toolbar item name. */
        item?: string;
        itemConstructor?: any;
        /** Item label  */
        label?: string;
        /** Item location */
        location?: string;
        /** Function to execute on item click.  */
        onClick?: () => void;
        /** Whether to show button label.  */
        showLabel?: boolean;
        /** Item side. */
        side?: string;
        /** Item title, shown on hover.  */
        title?: string;
    }
    export interface FacetChartFacet {
        activeItemId: string;
        count: number;
        data: any;
        from: number;
        getActiveItem(): FacetChartItem;
        id: string;
        items: Array<FacetChartItem>;
        left: number;
        loading: boolean;
        offset: number;
        opacity: number;
        parentItem: FacetChartItem;
        rebuild: boolean;
        right: number;
        to: number;
        totalCount: number;
    }
    export interface FacetChartItem {
        active: boolean;
        currentLabel: any;
        data: any;
        expandable: boolean;
        facet: FacetChartFacet;
        id: string;
        index: number;
        innerFacet: FacetChartFacet;
        label: any;
        selected: boolean;
        url: string;
        values: Array<FacetChartItemValue>;
    }
    export interface FacetChartItemValue {
        currentLabel: any;
        data: any;
        facet: FacetChartFacet;
        fillColor: any;
        id: string;
        index: number;
        label: any;
        lineColor: any;
        lineWidth: number;
        /** if true contents of the column are rendered on it  */
        previewContents: boolean;
        /** data to preview if previewContents = true  */
        previewData: any;
        seriesId: string;
        value: number;
    }
    export interface FacetChartSettings {
        advanced?: BaseSettingsAdvanced;
        /** Chart area related settings. */
        area?: LinearChartSettingsArea;
        assetsUrlBase?: string;
        /** Default series settings for each series rendering type. Use this to configure all series of specific type to get line or column chart or combination of them. */
        chartTypes?: {
            /** Series type to show an opening and closing value on top of a total variance. */
            candlestick?: LinearChartSettingsSeriesCandleStick;
            /** Series type to render values as vertical bars. */
            columns?: LinearChartSettingsSeriesColumns;
            /** Series type to connect value points by lines. */
            line?: LinearChartSettingsSeriesLines;
        };
        /** Element of the page where the chart will be inserted. For example a div. Any contents of the element will be cleared.
        Note that a single element can host only one chart.  */
        container?: (string|HTMLElement);
        credits?: BaseSettingsCredits;
        data?: Array<PieChartSettingsData>;
        /** The events used to handle user interaction with UI elements. See see::interactivity/::events:: for more info. */
        events?: BaseSettingsEvents;
        /** Chart x-axis line rendered at the bottom horizontally to display group names under each bar. */
        facetAxis?: FacetChartSettingsFacetAxis;
        /** Configurable conditions to filter the raw data values for subset of drawing facets. */
        filters?: {
            /** Determine whether to show item or not. */
            sliceFilter?: (
                /** the item to test */
                item: any) => boolean;
        };
        /** Info popup when hovering over columns or lines. Content returned in a form of html and is relevant to context of series hovered. */
        info?: LinearChartSettingsInfoPopup;
        /** A variety of interaction options that includes scrolling, zooming and swipe. */
        interaction?: FacetChartSettingsInteraction;
        /** Series cluster including name placed on facet axis. */
        items?: {
            /** Facet item style.  */
            style?: {
                /** Whether to open series item on click  */
                expandable?: boolean;
                /** Facet item text  */
                label?: string;
            };
            /** Dynamically determine item style from data.  */
            styleFunction?: (
                /** item to apply predefined style */
                item: any, 
                /** data relevant to item */
                itemData: any) => void;
        };
        /** The chart legend by additional interactivity to change the visibility of series it corresponds. */
        legend?: LinearChartSettingsLegend;
        /** Localizeable strings including export type options and useful default buttons used for chart interaction.
        Buttons like to navigate back, set the chart on full screen and others. */
        localization?: LinearChartSettingsLocalization;
        /** Settings to specify initial view once the page loaded. */
        navigation?: {
            /** Initial facet drilldown to show. For example ['', 'Firefox', 'Firefox 2.5'] denotes to various browsers grouped by versions.  */
            initialDrilldown?: Array<string>;
            /** Initial scroll offset, number of items from start. */
            initialOffset?: number;
            initialSelection?: Array<any>;
        };
        /** Parent chart to place this chart as subchart.
        Use area.left, area.top, area.width, area.height to position the subchart within parent chart. */
        parentChart?: BaseApi;
        /** Left, right scroll buttons if additional facets available */
        scrollButtons?: FacetChartSettingsScrollButtons;
        /** Array of series in the chart. Each of the series can be different type, can use different data source and
        aggregation. Additionally, series can be clustered and stacked. */
        series?: Array<LinearChartSettingsSeries>;
        /** The default series used as the chart dominant data. Use settings.series array to specify actual series. */
        seriesDefault?: LinearChartSettingsSeries;
        /** Defines stack settings to use in series. Each property is a stack name and value is stack settings.
        Values stack of each series on top of each other in the specified series order. Those, stacked bars help
        to visualize data that is a sum of parts, each of which is in a series.  */
        stacks?: Dictionary<LinearChartSettingsStack>;
        /** Theme to apply. Should contain an javascript object with additional settings.  */
        theme?: BaseSettings;
        /** The chart's main title. */
        title?: BaseSettingsTitle;
        /** Adjustable settings to manage default and custom toolbar items, as well as toolbar overall appearance. */
        toolbar?: BaseSettingsToolbar;
        /** Map from name to configuration. Currently supported are default and secondary. Default value axis is located on the left hand side of the chart and 
        secondary is located on the right hand side. Both can be configured to be either inside or outside the chart.  */
        valueAxis?: Dictionary<LinearChartSettingsValueAxis>;
        valueAxisDefault?: LinearChartSettingsValueAxis;
    }
    export interface FacetChartSettingsFacetAxis {
        /** Default width of one item. Used to calculate initial view. */
        defaultUnitWidth?: number;
        /** Show/hide facet axis.  */
        enabled?: boolean;
        /** Facet axis name settings.  */
        labels?: FacetChartSettingsFacetAxisLabels;
        /** Maximum width of one item. */
        maxUnitWidth?: number;
        /** Height of the x axis. */
        size?: number;
    }
    export interface FacetChartSettingsFacetAxisLabels {
        /** Text alignment. */
        align?: string;
        /** The angle at which the label are rotated */
        angle?: number;
        /** Ratio between label sizes in different dimensions */
        aspectRatio?: number;
        /** Background style including fill color.  */
        backgroundStyle?: BaseSettingsBackgroundStyle;
        /** Radius of item border. Similar to CSS border radius property. Zero radius will show a rectangle */
        borderRadius?: number;
        enabled?: boolean;
        /** Label image. */
        image?: string;
        /** Slicing to use tiled images. Array of 4 values: [left, top, width, height]  */
        imageSlicing?: [number, number, number, number];
        interLabelSpacing?: number;
        /** Vertical space between the lines of text. In multiples of text line height. */
        lineSpacing?: number;
        /** Margin around label text */
        margin?: number;
        /** Maximum width of the label. */
        maxWidth?: number;
        /** Padding between item content and item border. */
        padding?: number;
        /** Label text.  */
        text?: string;
        /** Text style including fill color and font.  */
        textStyle?: BaseSettingsTextStyle;
    }
    export interface FacetChartSettingsInteraction {
        /** Chart animation settings. */
        animation?: {
            /** Duration of hover animation. */
            hoverDuration?: number;
            /** Duration of scroll animation. */
            scrollDuration?: number;
        };
        resizing?: BaseSettingsResizer;
        /** Configurable settings to manage scroll interaction. */
        scrolling?: LinearChartSettingsInteractionScrolling;
        /** Configurable settings for select option. */
        selection?: FacetChartSettingsInteractionSelection;
        /** Sensitivity of Left/Right/Up/Down swipes. */
        swipeSensitivity?: number;
        /** Configurable settings to enhance and alleviate zoom interaction. */
        zooming?: {
            /** Enable/Disable zooming options.  */
            enabled?: boolean;
            /** Whether to zoom by two finger pinch.  */
            fingers?: boolean;
            /** Max zoom difference when using pinch gesture. */
            fingersMaxZoom?: number;
            /** Chart is zoomed in or out by this factor when pressing Up or Down keys. */
            keyboardFactor?: number;
            /** Mouse zooming sensitivity. Note that bigger values correspond to faster zooming. */
            sensitivity?: number;
            /** Whether to zoom by swiping up or down.  */
            swipe?: boolean;
            /** How far pointer must be moved up or down in pixels before zooming activates. */
            upDownTreshold?: number;
            /** Whether to zoom by mouse wheel.  */
            wheel?: boolean;
            /** Zoomed area is highlighted if zoom is changed more number of times than this. */
            zoomHighlightThreshold?: number;
        };
    }
    export interface FacetChartSettingsInteractionSelection {
        /** Enable/disable selection  */
        enabled?: boolean;
        tolerance?: number;
    }
    export interface FacetChartSettingsScrollButtons {
        /** Show/hide left, right scroll buttons if additional facets available.  */
        enabled?: boolean;
        /** Whether to display title on the exported image. Note that it does not affect chart.  */
        enabledOnExport?: boolean;
        /** Button height or width. */
        size?: number;
        /** Scroll button style  */
        style?: {
            fillColor?: string;
            hoverFillColor?: string;
            hoverLineColor?: string;
            lineColor?: string;
        };
    }
    export interface GeoChartAggregationDataObjectNode {
        aggregate?: any;
        /** Contains all original node data objects that have been aggregated into this instance  */
        aggregatedNodes: Array<GeoChartDataObjectNode>;
        aggregatedWeight: number;
        /** Coordinates can specify a point (for example, [0, 2]) or a shape (an array containing separate polygons, where each polygon
        is an array of concatenated X/Y coordinate pairs, for example [[0,2,2,2,2,0],[10,10,12,12]])  */
        coordinates?: ([number, number]|Array<Array<number>>);
        count?: any;
        id: string;
        loaded: boolean;
    }
    export interface GeoChartDataObject {
        east: number;
        error?: string;
        links: Array<GeoChartDataObjectLink>;
        nodes: Array<GeoChartDataObjectNode>;
        north: number;
        south: number;
        west: number;
    }
    export interface GeoChartDataObjectLink {
        from: string;
        /** The unique identifier of the node.  */
        id?: string;
        to: string;
        value?: number;
    }
    export interface GeoChartDataObjectNode {
        aggregate?: any;
        /** Coordinates can specify a point (for example, [0, 2]) or a shape (an array containing separate polygons, where each polygon
        is an array of concatenated X/Y coordinate pairs, for example [[0,2,2,2,2,0],[10,10,12,12]])  */
        coordinates?: ([number, number]|Array<Array<number>>);
        count?: any;
        id: string;
        loaded: boolean;
    }
    export interface GeoChartDataRequest {
        aggregateLat: Array<number>;
        aggregateLng: Array<number>;
        aggregateMinItems: number;
        east: number;
        id: string;
        layerId: string;
        north: number;
        south: number;
        west: number;
        zoom: number;
    }
    export interface GeoChartSettings {
        advanced?: ItemsChartSettingsAdvanced;
        /** Chart area related settings. */
        area?: BaseSettingsArea;
        assetsUrlBase?: string;
        background?: GeoChartSettingsBackground;
        /** Element of the page where the chart will be inserted. For example a div. Any contents of the element will be cleared.
        Note that a single element can host only one chart.  */
        container?: (string|HTMLElement);
        credits?: BaseSettingsCredits;
        data?: Array<GeoChartSettingsData>;
        /** The events used to handle user interaction with UI elements. See see::interactivity/::events:: for more info. */
        events?: BaseSettingsEvents;
        filters?: {
            nodeFilter?: (node: GeoChartDataObjectNode) => boolean;
        };
        /** Info popup for item - meaning links or nodes - with configurable content rendered. */
        info?: {
            /** Show/hide info popup  */
            enabled?: boolean;
            /** Returns html string to display in passed links info popup. */
            linkContentsFunction?: (
                /** link object */
                link: any) => any;
            /** Returns html string to display in passed nodes info popup. */
            nodeContentsFunction?: (
                /** node object */
                node: any) => any;
        };
        /** Customise chart resize handles or animation duration settings. */
        interaction?: GeoChartSettingsInteraction;
        /** The default values for specific layer types. Any custom values in specified in `layers` property will be applied on top of the
        values specified here, based on the `type` property witin them. */
        layerTypes?: {
            aggregateOnShapes?: GeoChartSettingsLayerAggregated;
            charts?: GeoChartSettingsLayerCharts;
            items?: GeoChartSettingsLayerItems;
            shapes?: GeoChartSettingsLayerShapes;
        };
        /** An array of objects. Have a look at "layerTypes" for the possible object types  */
        layers?: Array<GeoChartSettingsLayerBase>;
        /** Specifies the defaults for all layers, independent of the layer type.
        @deprecated - This section is no longer used, specify the defaults in `layerTypes` section, based on the appropriate layer type. */
        layersDefault?: any;
        legend?: BaseSettingsLegend;
        /** Configurable link menu with option to specify a range of displaying buttons. */
        linkMenu?: ItemsChartSettingsLinkMenu;
        /** Localizeable strings including export type options and useful default buttons used for chart interaction.
        Buttons like to navigate back, set the chart on full screen and others. */
        localization?: BaseSettingsLocalization;
        navigation?: {
            drilldownLayer?: string;
            initialDrilldown?: Array<string>;
            /** Specify latitude of the initial center coordinate (WGS-84 degrees)  */
            initialLat?: number;
            /** Specify longitude of the initial center coordinate (WGS-84 degrees)  */
            initialLng?: number;
            /** Specify the initial zoom level for the chart. (For most chart data sources, valid values are 0..18 inclusive). */
            initialZoom?: number;
            maxBounds?: {
                east?: number;
                north?: number;
                south?: number;
                west?: number;
            };
            maxZoom?: number;
            minZoom?: number;
        };
        /** Configurable node menu with option to specify a range of displaying buttons. */
        nodeMenu?: ItemsChartSettingsNodeMenu;
        /** Parent chart to place this chart as subchart.
        Use area.left, area.top, area.width, area.height to position the subchart within parent chart. */
        parentChart?: BaseApi;
        style?: {
            fadeTime?: number;
            selection?: {
                fillColor?: string;
                sizeConstant?: number;
                sizeProportional?: number;
            };
        };
        /** Theme to apply. Should contain an javascript object with additional settings.  */
        theme?: GeoChartSettings;
        /** The chart's main title. */
        title?: BaseSettingsTitle;
        /** Adjustable settings to manage default and custom toolbar items, as well as toolbar overall appearance. */
        toolbar?: BaseSettingsToolbar;
    }
    export interface GeoChartSettingsAggregation {
        /** The approximate minimum distance in pixels between two nodes before they are aggregated together. */
        distance?: number;
        /** Enables/Disables automatic aggregation  */
        enabled?: boolean;
        /** The last zoom level on which the nodes are automatically agregated. When the chart is zoomed in deeper, the original
        nodes will be used instead. */
        maxZoom?: number;
        /** A delegate that can be used to process aggregated nodes before links are aggregated.
        The delegate should modify the given array and mapping information if some nodes should be
        aggregated differently.  */
        postProcessAggregatedNodes?: (
            /** The aggregated node objects.  */
            nodes: Array<GeoChartAggregationDataObjectNode>, 
            /** A dictionary that maps the original node ID to the aggregated node (the same instance that is present in the `nodes` array). */
            map: Dictionary<GeoChartAggregationDataObjectNode>, 
            /** An empty array that the delegate is expected to fill with aggregated nodes that have been modified.  */
            modifiedNodes: Array<GeoChartAggregationDataObjectNode>) => void;
        /** Function that returns the value used as weight in the aggregation process for each node.  */
        weightFunction?: (node: GeoChartDataObjectNode) => number;
    }
    export interface GeoChartSettingsBackground {
        enabled?: boolean;
        params?: {
            attribution?: string;
            subdomains?: Array<string>;
        };
        type?: string;
        url?: string;
    }
    export interface GeoChartSettingsData {
        aggregationGridSize?: number;
        aggregationMinCount?: number;
        bounds?: [number, number, number, number];
        /** Count of caching items including only links and nodes. */
        cacheSize?: number;
        dataFunction?: (request: GeoChartDataRequest, success: (data: GeoChartDataObject) => void, fail: (result: BaseDataErrorResponse) => void) => void;
        /** Data loading format. Currently only JSON supported. */
        format?: string;
        /** Data id used for series to reference specific data source.  */
        id?: string;
        maxRequestRect?: [number, number];
        /** Max number of parallel data requests to issue. More requests will result in faster loading, but might put heavy load on server. */
        numberOfParallelRequests?: number;
        /** If true, data source will use bounds to limit response, if false, assume all data is returned. */
        perBoundsData?: boolean;
        /** If true, separate data aviable at each drilldown level. Used in Renderer. */
        perDrilldownData?: boolean;
        /** If true, separate data available at each zoom level. Used in Renderer and here. */
        perZoomData?: boolean;
        /** Delegate that can be used to process data returned by the server for the HTTP request issued by the chart. */
        postprocessorFunction?: (
            /** The raw data received from the server.  */
            data: any) => any;
        prefetchRatio?: number;
        /** Whether to load links for all disabled nodes automatically. Otherwise, links will be loaded only when expanding a node.  */
        preloadNodeLinks?: boolean;
        /** Provides the ability to embed chart data directly into the chart configuration.
        Data can be represented by an JavaScript object or a JSON string.  */
        preloaded?: (string|GeoChartDataObject);
        /** Specifies the random layout method: grid, tree, uniform. The default is uniform. */
        random?: string;
        randomGridLinkProbability?: number;
        /** Generates random data.  */
        randomLinks?: number;
        /** Generates random data. Specify a value larger than 0 to enable generating random data. */
        randomNodes?: number;
        randomTreeDensity?: number;
        /** Max number of nodes to submit in a single request. */
        requestMaxUnits?: number;
        /** Timeout in milliseconds for data requests. This timeout only applies to HTTP requests issued by the chart directly. */
        requestTimeout?: number;
        /** URL to load more data. URL parameters: from, to, unit */
        url?: string;
        /** List of extra parameters to pass with data URL.  */
        urlParameters?: Array<{
                /** Parameter name. */
                name?: string;
                /** Parameter value. */
                value?: string;
            }>;
        wrapLng?: boolean;
    }
    export interface GeoChartSettingsInteraction {
        /** Chart animation settings. */
        animation?: {
            /** Duration of hover animation. */
            hoverDuration?: number;
            /** Duration of scroll animation. */
            scrollDuration?: number;
        };
        mode?: string;
        /** Whether to allow moving nodes around.  */
        nodesMovable?: boolean;
        /** Move chart vertically and horizontally by clicking on the main chart pane and dragging it on any direction. */
        panning?: {
            /** Enables/disables chart panning.  */
            enabled?: boolean;
        };
        resizing?: BaseSettingsResizer;
        /** Select node to expand it or getting path. */
        selection?: ItemsChartSettingsInteractionSelection;
        /** Zoom in or out by swiping up or down with mouse scroll pad or by using the Zoom-out feature at the top left. */
        zooming?: ItemsChartSettingsInteractionZooming;
    }
    export interface GeoChartSettingsLayerAggregated {
        /** Aggregation function to use. */
        aggregation?: string;
        /** Data field used for aggregation.  */
        aggregationField?: string;
        /** Custom function to call for aggregation */
        aggregationFunction?: (
            /** array of nodes matching single shape */
            nodesArray: any) => any;
        data?: {
            id?: string;
        };
        enabled?: boolean;
        id?: string;
        maxZoom?: number;
        minZoom?: number;
        name?: string;
        /** Forces style re-evaluation on zoom change. Use to provide zoom dependant style.  */
        perZoomStyle?: boolean;
        /** The ID of a linked shapes layer. Style changes will be applied to this layer. The shapes layer must be defined before the aggregation layer.  */
        shapesLayer?: string;
        /** Function for applying the aggregated value on node.  */
        styleFunction?: (
            /** shape node style is being applied to */
            node: any, 
            /** computed aggregate value */
            value: any) => void;
        type?: string;
    }
    export interface GeoChartSettingsLayerBase {
        data?: {
            id?: string;
        };
        enabled?: boolean;
        id?: string;
        maxZoom?: number;
        minZoom?: number;
        name?: string;
        /** Forces style re-evaluation on zoom change. Use to provide zoom dependant style.  */
        perZoomStyle?: boolean;
        type?: string;
    }
    export interface GeoChartSettingsLayerCharts {
        /** Chart type to use */
        chartType?: string;
        data?: {
            /** ID should be `null` because the charts layer does not retrieve data this way.  */
            id?: string;
        };
        enabled?: boolean;
        id?: string;
        maxZoom?: number;
        minZoom?: number;
        name?: string;
        /** Forces style re-evaluation on zoom change. Use to provide zoom dependant style.  */
        perZoomStyle?: boolean;
        /** The settings that will be passed to each nested chart. Note that if `settingsFunction` is also specified, these
        settings will not be used and `settingsFunction` will be called instead. */
        settings?: (TimeChartSettings|FacetChartSettings|PieChartSettings);
        /** The delegate that will be used to retrieve custom setting for a particular node. This function is called every time the node is modified.
        The result should only contain modified settings that will be passed to `chart.updateSettings()`.  */
        settingsFunction?: (node: ItemsChartNode, data: GeoChartDataObjectNode) => (TimeChartSettings|FacetChartSettings|PieChartSettings);
        /** The charts layer will take data from shapes or nodes layer and creates a chart for every shape/node.  */
        shapesLayer?: string;
        type?: string;
    }
    export interface GeoChartSettingsLayerItems {
        /** Controls automatic proximity based aggregation. */
        aggregation?: GeoChartSettingsAggregation;
        data?: {
            id?: string;
        };
        enabled?: boolean;
        id?: string;
        layout?: GeoChartSettingsNodesLayout;
        maxZoom?: number;
        minZoom?: number;
        name?: string;
        /** Forces style re-evaluation on zoom change. Use to provide zoom dependant style.  */
        perZoomStyle?: boolean;
        style?: GeoChartSettingsNodesLayerStyle;
        type?: string;
    }
    export interface GeoChartSettingsLayerShapes {
        data?: {
            id?: string;
        };
        enabled?: boolean;
        id?: string;
        maxZoom?: number;
        minZoom?: number;
        name?: string;
        /** Forces style re-evaluation on zoom change. Use to provide zoom dependant style.  */
        perZoomStyle?: boolean;
        style?: GeoChartSettingsShapesLayerStyle;
        type?: string;
    }
    export interface GeoChartSettingsNodesLayerStyle {
        /** The style used to draw convex shapes for the automatically aggregated nodes.  */
        aggregatedShape?: BaseSettingsBackgroundStyle;
        /** *
          An "all included" style function.
          @returns - links and nodes that the style function has modified. Or `null` to mark all objects as modified. */
        allObjectsStyleFunction?: (
            /** all nodes that currently loaded on the chart */
            nodes: Array<ItemsChartNode>, 
            /** all links that are currently loaded on the chart */
            links: Array<ItemsChartLink>) => {
                modifiedNodes: Array<ItemsChartNode>;
                modifiedLinks: Array<ItemsChartLink>;
            };
        /** Removed object fadeout time. */
        fadeTime?: number;
        /** style for hidden link hints.  */
        hiddenLinks?: {
            fillColor?: string;
            lineColor?: string;
            lineWidth?: number;
            size?: number;
        };
        /** Items are small UI elements that provide extra information. Items are attached to nodes or links and can display a label, image or both.  */
        item?: BaseSettingsLabelStyle;
        /** Default link style.  */
        link?: ItemsChartSettingsLinkStyle;
        /** Link radius auto distribution method. */
        linkAutoScaling?: string;
        /** The class rules to apply individual style for link subset. Use known CSS class definition practice.
        Define one or more classes by specifying name and style and apply those by node definition. If multiple
        classes applied separate them with space and class rules will cascade in order of class definition.  */
        linkClasses?: Array<{
                /** Class name  */
                className?: string;
                /** Style settings  */
                style?: ItemsChartSettingsLinkStyle;
            }>;
        /** Link decorations are not painted if link is shorter than this. */
        linkDecorationMinSize?: number;
        /** Link decoration size calculated as a product of the link radius and scale factor. The value lower than linkDecorationMinSize will take no effect. */
        linkDecorationScale?: number;
        /** Link details like labels, items are hidden if link width in pixels is below this value. */
        linkDetailMinSize?: number;
        /** Link details like labels, items are not rendered if chart zoom is below this value. */
        linkDetailMinZoom?: number;
        /** Additional style to apply when a link is hovered.  */
        linkHovered?: ItemsChartSettingsLinkStyle;
        /** Link text style  */
        linkLabel?: ItemsChartSettingsItemsLayerLabelStyle;
        /** Base node size of link label that scales with link size. */
        linkLabelScaleBase?: number;
        /** Link length auto distribution method. */
        linkLengthAutoScaling?: string;
        /** Min and max value of link length before zooming is applied. */
        linkLengthExtent?: [number, number];
        /** Min and max value of link half-width before zooming is applied. */
        linkRadiusExtent?: [number, number];
        /** An object defining one or more functions used to calculate node rendering style.
        Structure: { 'rule1':function1(nodeObj), 'rule2':function2(nodeObj) }
        The functions are executed in lexicographic order whenever node data or links change.
        Each function can modify the nodeObj to add specific style elements.
        @deprecated - use linkStyleFunction instead */
        linkRules?: Dictionary<(node: ItemsChartLink) => void>;
        linkSelected?: ItemsChartSettingsLinkStyle;
        /** Link strength auto distribution method. */
        linkStrengthAutoScaling?: string;
        /** Min and max value for link strength. */
        linkStrengthExtent?: [number, number];
        /** A a style function for links. Will be called whenever a link property or data has changed.
        Use to dynamically set link style fields. */
        linkStyleFunction?: (node: ItemsChartLink) => void;
        /** Distance between multiple links between two nodes. */
        multilinkSpacing?: number;
        /** Default node style.  */
        node?: ItemsChartSettingsNodeStyle;
        /** Default node  anchor style.  */
        nodeAnchor?: ItemsChartSettingsNodeAnchorStyle;
        /** Controls automatic node scaling. */
        nodeAutoScaling?: string;
        /** The class rules to apply individual style for node subset. Use known CSS class definition practice.
        Define one or more classes by specifying name and style and apply those by node definition. If multiple
        classes applied separate them with space and class rules will cascade in order of class definition.  */
        nodeClasses?: Array<{
                /** Class name  */
                className?: string;
                /** Style settings  */
                style?: ItemsChartSettingsNodeStyle;
            }>;
        /** Node details like labels, items, images are hidden if node width in pixels is below this value. */
        nodeDetailMinSize?: number;
        /** Node details like labels, items, images are not rendered if chart zoom is below this value. */
        nodeDetailMinZoom?: number;
        /** Additional style to apply when node is expanded.  */
        nodeExpanded?: ItemsChartSettingsNodeStyle;
        /** Additional style to apply when node is focused.  */
        nodeFocused?: ItemsChartSettingsNodeStyle;
        /** Additional style to apply when a node is hovered.  */
        nodeHovered?: ItemsChartSettingsNodeStyle;
        /** Node label style.  */
        nodeLabel?: ItemsChartSettingsItemsLayerLabelStyle;
        /** Base node size of node label that scales with node size. */
        nodeLabelScaleBase?: number;
        /** Additional style to apply when a node position is locked.  */
        nodeLocked?: ItemsChartSettingsNodeStyle;
        /** Additional style to apply when node data is not yet loaded.  */
        nodeNotLoaded?: ItemsChartSettingsNodeStyle;
        /** Min and max value of node radius, before zooming is applied. */
        nodeRadiusExtent?: [number, number];
        /** An object defining one or more functions used to calculate node rendering style.
        See see::examples/style/round-image-nodes.html::round image nodes:: example. 
        @deprecated - use nodeStyleFunction instead */
        nodeRules?: Dictionary<(node: ItemsChartNode) => void>;
        nodeSelected?: ItemsChartSettingsNodeStyle;
        /** A a style function for nodes. Will be called whenever a node property or data has changed.
        Use to dynamically set node style fields. */
        nodeStyleFunction?: (node: ItemsChartNode) => void;
        /** Color for fade out animation of removed objects. */
        removedColor?: string;
        /** Whether to set actual node radius zoom-dependent instead of always fixed.  */
        scaleObjectsWithZoom?: boolean;
        selection?: {
            fillColor?: string;
            sizeConstant?: number;
            sizeProportional?: number;
        };
    }
    export interface GeoChartSettingsNodesLayout {
        /** Anchor strength, relative to link strength. */
        anchorStrength?: number;
        /** Layout mode. */
        mode?: string;
        /** Desired distance between nodes. */
        nodeSpacing?: number;
    }
    export interface GeoChartSettingsShapesLayerNodeStyle {
        /** Node anchor mode. */
        anchorMode?: ItemsChartNodeAnchorMode;
        anchorStyle?: ItemsChartSettingsNodeAnchorStyle;
        /** Node anchor y position. If not set, initial position will be calculated automatically and conserved.
        The coordinate space is dependant on `anchorMode` value.
        * anchorMode = "Scene" - the value is in scene coordinates.
        * anchorMode = "Display" - the value is in pixels from top-left corner of the chart area. */
        anchorX?: number;
        /** Node anchor y position. If not set, initial position will be calculated automatically and conserved.
        The coordinate space is dependant on `anchorMode` value.
        * anchorMode = "Scene" - the value is in scene coordinates.
        * anchorMode = "Fixed" - the value is in pixels from top-left corner of the chart area. */
        anchorY?: number;
        coordinates?: (Array<number>|Array<Array<number>>);
        /** Cursor to show when node is hovered. */
        cursor?: string;
        /** Custom shape settings supplied, if display == "customShape" */
        customShape?: ItemsChartSettingsCustomShape;
        /** Valid values: image, text, roundtext, customShape, line, polygon, circle, droplet  */
        display?: string;
        /** Specifies if the node representing the shape can be drilled down into.  */
        expandable?: boolean;
        fillColor?: string;
        image?: string;
        /** Specifies the image cropping method. Valid values are `false` (disable cropping), `true` (default cropping mode), `"crop"`, `"letterbox"` and `"fit"`.  */
        imageCropping?: (string|boolean);
        /** The label text that is displayed below the node. Set to an empty string "" to remove the label if it has been added before.  */
        label?: string;
        labelStyle?: ItemsChartSettingsItemsLayerLabelStyle;
        lineColor?: string;
        lineDash?: Array<number>;
        lineWidth?: number;
        /** Node opacity. */
        opacity?: number;
        radius?: number;
        shadowBlur?: number;
        shadowColor?: string;
        shadowOffsetX?: number;
        shadowOffsetY?: number;
    }
    export interface GeoChartSettingsShapesLayerStyle {
        /** The style used to draw convex shapes for the automatically aggregated nodes.  */
        aggregatedShape?: BaseSettingsBackgroundStyle;
        /** *
          An "all included" style function.
          @returns - links and nodes that the style function has modified. Or `null` to mark all objects as modified. */
        allObjectsStyleFunction?: (
            /** all nodes that currently loaded on the chart */
            nodes: Array<ItemsChartNode>, 
            /** all links that are currently loaded on the chart */
            links: Array<ItemsChartLink>) => {
                modifiedNodes: Array<ItemsChartNode>;
                modifiedLinks: Array<ItemsChartLink>;
            };
        /** Removed object fadeout time. */
        fadeTime?: number;
        /** style for hidden link hints.  */
        hiddenLinks?: {
            fillColor?: string;
            lineColor?: string;
            lineWidth?: number;
            size?: number;
        };
        /** Items are small UI elements that provide extra information. Items are attached to nodes or links and can display a label, image or both.  */
        item?: BaseSettingsLabelStyle;
        /** Default link style.  */
        link?: ItemsChartSettingsLinkStyle;
        /** Link radius auto distribution method. */
        linkAutoScaling?: string;
        /** The class rules to apply individual style for link subset. Use known CSS class definition practice.
        Define one or more classes by specifying name and style and apply those by node definition. If multiple
        classes applied separate them with space and class rules will cascade in order of class definition.  */
        linkClasses?: Array<{
                /** Class name  */
                className?: string;
                /** Style settings  */
                style?: ItemsChartSettingsLinkStyle;
            }>;
        /** Link decorations are not painted if link is shorter than this. */
        linkDecorationMinSize?: number;
        /** Link decoration size calculated as a product of the link radius and scale factor. The value lower than linkDecorationMinSize will take no effect. */
        linkDecorationScale?: number;
        /** Link details like labels, items are hidden if link width in pixels is below this value. */
        linkDetailMinSize?: number;
        /** Link details like labels, items are not rendered if chart zoom is below this value. */
        linkDetailMinZoom?: number;
        /** Additional style to apply when a link is hovered.  */
        linkHovered?: ItemsChartSettingsLinkStyle;
        /** Link text style  */
        linkLabel?: ItemsChartSettingsItemsLayerLabelStyle;
        /** Base node size of link label that scales with link size. */
        linkLabelScaleBase?: number;
        /** Link length auto distribution method. */
        linkLengthAutoScaling?: string;
        /** Min and max value of link length before zooming is applied. */
        linkLengthExtent?: [number, number];
        /** Min and max value of link half-width before zooming is applied. */
        linkRadiusExtent?: [number, number];
        /** An object defining one or more functions used to calculate node rendering style.
        Structure: { 'rule1':function1(nodeObj), 'rule2':function2(nodeObj) }
        The functions are executed in lexicographic order whenever node data or links change.
        Each function can modify the nodeObj to add specific style elements.
        @deprecated - use linkStyleFunction instead */
        linkRules?: Dictionary<(node: ItemsChartLink) => void>;
        linkSelected?: ItemsChartSettingsLinkStyle;
        /** Link strength auto distribution method. */
        linkStrengthAutoScaling?: string;
        /** Min and max value for link strength. */
        linkStrengthExtent?: [number, number];
        /** A a style function for links. Will be called whenever a link property or data has changed.
        Use to dynamically set link style fields. */
        linkStyleFunction?: (node: ItemsChartLink) => void;
        /** Distance between multiple links between two nodes. */
        multilinkSpacing?: number;
        /** Default node style.  */
        node?: GeoChartSettingsShapesLayerNodeStyle;
        /** Default node  anchor style.  */
        nodeAnchor?: ItemsChartSettingsNodeAnchorStyle;
        /** Controls automatic node scaling. */
        nodeAutoScaling?: string;
        /** The class rules to apply individual style for node subset. Use known CSS class definition practice.
        Define one or more classes by specifying name and style and apply those by node definition. If multiple
        classes applied separate them with space and class rules will cascade in order of class definition.  */
        nodeClasses?: Array<{
                /** Class name  */
                className?: string;
                /** Style settings  */
                style?: ItemsChartSettingsNodeStyle;
            }>;
        /** Node details like labels, items, images are hidden if node width in pixels is below this value. */
        nodeDetailMinSize?: number;
        /** Node details like labels, items, images are not rendered if chart zoom is below this value. */
        nodeDetailMinZoom?: number;
        /** Additional style to apply when node is expanded.  */
        nodeExpanded?: ItemsChartSettingsNodeStyle;
        /** Additional style to apply when node is focused.  */
        nodeFocused?: ItemsChartSettingsNodeStyle;
        /** Additional style to apply when a node is hovered.  */
        nodeHovered?: ItemsChartSettingsNodeStyle;
        /** Node label style.  */
        nodeLabel?: ItemsChartSettingsItemsLayerLabelStyle;
        /** Base node size of node label that scales with node size. */
        nodeLabelScaleBase?: number;
        /** Additional style to apply when a node position is locked.  */
        nodeLocked?: ItemsChartSettingsNodeStyle;
        /** Additional style to apply when node data is not yet loaded.  */
        nodeNotLoaded?: ItemsChartSettingsNodeStyle;
        /** Min and max value of node radius, before zooming is applied. */
        nodeRadiusExtent?: [number, number];
        /** An object defining one or more functions used to calculate node rendering style.
        See see::examples/style/round-image-nodes.html::round image nodes:: example. 
        @deprecated - use nodeStyleFunction instead */
        nodeRules?: Dictionary<(node: ItemsChartNode) => void>;
        nodeSelected?: ItemsChartSettingsNodeStyle;
        /** A a style function for nodes. Will be called whenever a node property or data has changed.
        Use to dynamically set node style fields. */
        nodeStyleFunction?: (node: ItemsChartNode) => void;
        /** Color for fade out animation of removed objects. */
        removedColor?: string;
        /** Whether to set actual node radius zoom-dependent instead of always fixed.  */
        scaleObjectsWithZoom?: boolean;
        selection?: {
            fillColor?: string;
            sizeConstant?: number;
            sizeProportional?: number;
        };
    }
    export interface ItemsChartLink {
        cursor?: string;
        data: any;
        /** null or "U", "D", "L", "R"  */
        direction?: string;
        fillColor?: string;
        from: ItemsChartNode;
        fromDecoration?: string;
        hovered: boolean;
        id: string;
        items?: Array<ItemsChartSettingsLinkItem>;
        label?: string;
        length?: number;
        lineDash?: Array<number>;
        /** Specifies the width of the line rendered for this link.  */
        radius?: number;
        selected: boolean;
        shadowBlur?: number;
        shadowColor?: string;
        shadowOffsetX?: number;
        shadowOffsetY?: number;
        strength?: number;
        to: ItemsChartNode;
        toDecoration?: string;
    }
    export interface ItemsChartNode {
        /** Node anchor mode. */
        anchorMode?: ItemsChartNodeAnchorMode;
        anchorStyle?: ItemsChartSettingsNodeAnchorStyle;
        /** Node anchor y position. If not set, initial position will be calculated automatically and conserved.
        The coordinate space is dependant on `anchorMode` value.
        * anchorMode = "Scene" - the value is in scene coordinates.
        * anchorMode = "Display" - the value is in pixels from top-left corner of the chart area. */
        anchorX?: number;
        /** Node anchor y position. If not set, initial position will be calculated automatically and conserved.
        The coordinate space is dependant on `anchorMode` value.
        * anchorMode = "Scene" - the value is in scene coordinates.
        * anchorMode = "Fixed" - the value is in pixels from top-left corner of the chart area. */
        anchorY?: number;
        background: boolean;
        coordinates?: (Array<number>|Array<Array<number>>);
        /** Cursor to show when node is hovered. */
        cursor?: string;
        /** Custom shape settings supplied, if display == "customShape" */
        customShape?: ItemsChartSettingsCustomShape;
        data: any;
        dataLinks: Array<any>;
        dataLinksFiltered: Array<any>;
        /** Valid values: image, text, roundtext, customShape, line, polygon, circle, droplet  */
        display?: string;
        expanded: boolean;
        fillColor?: string;
        focused: boolean;
        hovered: boolean;
        id: string;
        image?: string;
        /** Specifies the image cropping method. Valid values are `false` (disable cropping), `true` (default cropping mode), `"crop"`, `"letterbox"` and `"fit"`.  */
        imageCropping?: (string|boolean);
        /** The label text that is displayed below the node. Set to an empty string "" to remove the label if it has been added before.  */
        label?: string;
        labelStyle?: ItemsChartSettingsItemsLayerLabelStyle;
        lineColor?: string;
        lineDash?: Array<number>;
        lineWidth?: number;
        links: Array<ItemsChartLink>;
        /** Node opacity. */
        opacity?: number;
        radius?: number;
        relevance: number;
        selected: boolean;
        shadowBlur?: number;
        shadowColor?: string;
        shadowOffsetX?: number;
        shadowOffsetY?: number;
    }
    export enum ItemsChartNodeAnchorMode {
        Fixed = 2,
        /** Node if free-floating, */
        Floating = 0,
        Scene = 1,
    }
    export interface ItemsChartSettingsAdvanced {
        /** List of assets to load from assets directory. This should be used to load CSS files. */
        assets?: Array<string>;
        builtinAssets?: Dictionary<string>;
        /** URL for export proxy requests. */
        exportProxyURL?: string;
        /** Enables high resolution rendering on high DPI screens. As performance is varied across different browsers, disable this to
        improve the performance of your application.  */
        highDPI?: boolean;
        /** Whether to store entire label into bitmap. Use it to improve the performance of your application.  */
        labelCache?: boolean;
        /** Whether to show verbose logging.  */
        logging?: boolean;
        /** Maximum height of canvas object. The canvas will be stretched if chart is bigger that this. Note that increasing beyond 2048
        is known to cause loss of hardware acceleration on Safari/OSX. */
        maxCanvasHeight?: number;
        /** Maximum width of canvas object. The canvas will be stretched if chart is bigger that this. Note that increasing beyond 2048
        is known to cause loss of hardware acceleration on Safari/OSX. */
        maxCanvasWidth?: number;
        /** Extra assets to be loaded for pdfExport action. */
        pdfExportAssets?: Array<string>;
        /** Whether to display a loading indicator on every node, otherwise only a global loading indicator.  */
        perNodeLoadingIndicator?: boolean;
        /** Pointer related settings. */
        pointer?: BaseSettingsAdvancedPointer;
        /** Whether to show frames per second on the chart.  */
        showFPS?: boolean;
        /** Whether to show the current timestamp on the chart. Use only for debugging.  */
        showTimestamp?: boolean;
        /** Whether to use debugging option to paint pointer trails on screen.  */
        showTouches?: boolean;
        /** Miscellaneous style settings.  */
        style?: BaseSettingsAdvancedStyle;
        /** CSS class for current theme. Used to reference chart container in CSS files.  */
        themeCSSClass?: string;
        /** Whether to use requestAnimationFrame for requested paint instead of setTimeout.  */
        useAnimationFrame?: boolean;
    }
    /** If display attribute is "customShape", SettingsCustomShape are
    required to determine how to render the custom shape */
    export interface ItemsChartSettingsCustomShape {
        /** When drawing links/arrows to the shape it may be desirable to determine the point where the arrow
        reaches and touches the respective shape. Given the start point of the ray, this function should return
        the distance to the outer border of the shape */
        distanceToEdge?: (
            /** radius  */
            r: number, 
            /** width  */
            w: number, 
            /** the ray towards shape  */
            ddx: number, ddy: number) => number;
        /** As the shape may have a custom aspect ratio, given the radius, the getBounds method
        should return the bounding box of the shape */
        getBounds?: (node: ItemsChartNode) => [number, number, number, number];
        /** Function to test if hover action was over the respective shape */
        hitTest?: (x: number, y: number, itemScale: number, prevBest: number) => number;
        /** Method performed on update (such as hover) */
        onUpdate?: (node: ItemsChartNode) => void;
        /** Function to render the custom shape in canvas 2d context */
        paint?: (node: ItemsChartNode, 
            /** The canvas 2d rendering context for rendering  */
            context: CanvasRenderingContext2D, 
            /** The X value of the center coordinate, where node needs to be rendered  */
            x: number, 
            /** The Y value of the center coordinate where the node needs to be rendered */
            y: number, scale: number) => void;
    }
    export interface ItemsChartSettingsInteractionSelection {
        /** Whether to move nodes outside of screen area.  */
        allowMoveNodesOffscreen?: boolean;
        /** Enable/disable selection.  */
        enabled?: boolean;
        /** Whether to set links selectable.  */
        linksSelectable?: boolean;
        /** Whether to retain nodes location after being moved by the user.  */
        lockNodesOnMove?: boolean;
        /** Whether to set nodes selectable.  */
        nodesSelectable?: boolean;
        /** Max click distance from object that still counts as click on the object. */
        tolerance?: number;
    }
    export interface ItemsChartSettingsInteractionZooming {
        /** Whether to auto zoom every time user clicks on the chart.  */
        autoZoomAfterClick?: boolean;
        /** A double-click on empty space will trigger zoom in by this value. Set to null or false to disable double click zooming. */
        doubleClickZoom?: number;
        /** Whether to zoom by two finger pinch.  */
        fingers?: boolean;
        /** Sensitivity of wheel zoom. */
        sensitivity?: number;
        /** Whether to zoom by mouse wheel.  */
        wheel?: boolean;
        /** Enable/Disable zoom in on double click.  */
        zoomInOnDoubleClick?: boolean;
    }
    export interface ItemsChartSettingsItemsLayerLabelStyle {
        /** Text alignment. */
        align?: string;
        /** The angle at which the label are rotated */
        angle?: number;
        /** Ratio between label sizes in different dimensions */
        aspectRatio?: number;
        /** Background style including fill color.  */
        backgroundStyle?: BaseSettingsBackgroundStyle;
        /** Radius of item border. Similar to CSS border radius property. Zero radius will show a rectangle */
        borderRadius?: number;
        /** Label image. */
        image?: string;
        /** Slicing to use tiled images. Array of 4 values: [left, top, width, height]  */
        imageSlicing?: [number, number, number, number];
        /** Vertical space between the lines of text. In multiples of text line height. */
        lineSpacing?: number;
        /** Margin around label text */
        margin?: number;
        /** Maximum width of the label. */
        maxWidth?: number;
        /** Padding between item content and item border. */
        padding?: number;
        /** Whether to rotate link labels in the same direction as link  */
        rotateWithLink?: boolean;
        /** Whether to apply different scale according to initial size of the link or node.  */
        scaleWithSize?: boolean;
        /** Whether to apply the scale if zoom changes. If false, the label size never changes.  */
        scaleWithZoom?: boolean;
        /** Label text.  */
        text?: string;
        /** Text style including fill color and font.  */
        textStyle?: BaseSettingsTextStyle;
    }
    /** Link item. */
    export interface ItemsChartSettingsLinkItem {
        /** Text alignment. */
        align?: string;
        /** The angle at which the label are rotated */
        angle?: number;
        /** Ratio between label sizes in different dimensions */
        aspectRatio?: number;
        /** Background style including fill color.  */
        backgroundStyle?: BaseSettingsBackgroundStyle;
        /** Radius of item border. Similar to CSS border radius property. Zero radius will show a rectangle */
        borderRadius?: number;
        /** Label image. */
        image?: string;
        /** Slicing to use tiled images. Array of 4 values: [left, top, width, height]  */
        imageSlicing?: [number, number, number, number];
        /** Vertical space between the lines of text. In multiples of text line height. */
        lineSpacing?: number;
        /** Offset from link center along link direction. In pixels. */
        lx?: number;
        /** Offset from link center perpendicular to link direction. In pixels. */
        ly?: number;
        /** Margin around label text */
        margin?: number;
        /** Maximum width of the label. */
        maxWidth?: number;
        /** Padding between item content and item border. */
        padding?: number;
        /** Offset from link center along link direction. A fraction of link length.
        Value of -1 places the item at the start of the link.
        Value of 1 places the item at the end of the link. */
        px?: number;
        /** Offset from link center perpendicularly to link direction. A fraction of link radius. */
        py?: number;
        /** Whether to rotate link labels in the same direction as link  */
        rotateWithLink?: boolean;
        /** Whether to apply different scale according to initial size of the link or node.  */
        scaleWithSize?: boolean;
        /** Whether to apply the scale if zoom changes. If false, the label size never changes.  */
        scaleWithZoom?: boolean;
        /** Label text.  */
        text?: string;
        /** Text style including fill color and font.  */
        textStyle?: BaseSettingsTextStyle;
        /** X offset from link center in pixels. */
        x?: number;
        /** Y offset from link center in pixels. */
        y?: number;
    }
    export interface ItemsChartSettingsLinkMenu {
        /** Prepare html string to include in the menu. Called whenever a menu is about to be shown. */
        contentsFunction?: (
            /** node data */
            data: any, 
            /** the node object */
            node: any, 
            /** callback function */
            callback: (result: string) => void) => string;
        /** Show/hide node/link menu.  */
        enabled?: boolean;
        /** Whether to add a view data button to the menu. Useful for debugging.  */
        showData?: boolean;
    }
    export interface ItemsChartSettingsLinkStyle {
        cursor?: string;
        /** null or "U", "D", "L", "R"  */
        direction?: string;
        fillColor?: string;
        fromDecoration?: string;
        items?: Array<ItemsChartSettingsLinkItem>;
        label?: string;
        length?: number;
        lineDash?: Array<number>;
        /** Specifies the width of the line rendered for this link.  */
        radius?: number;
        shadowBlur?: number;
        shadowColor?: string;
        shadowOffsetX?: number;
        shadowOffsetY?: number;
        strength?: number;
        toDecoration?: string;
    }
    export interface ItemsChartSettingsNodeAnchorStyle {
        lineColor?: string;
        lineDash?: Array<number>;
        lineWidth?: number;
        shadowBlur?: number;
        shadowColor?: string;
        shadowOffsetX?: number;
        shadowOffsetY?: number;
    }
    export interface ItemsChartSettingsNodeMenu {
        /** Buttons to show in node menu.  */
        buttons?: Array<string>;
        /** Prepare html string to include in the menu. Called whenever a menu is about to be shown. */
        contentsFunction?: (
            /** node data */
            data: any, 
            /** the node object */
            node: any, 
            /** callback function */
            callback: (result: string) => void) => string;
        /** Show/hide node/link menu.  */
        enabled?: boolean;
        /** Whether to add a view data button to the menu. Useful for debugging.  */
        showData?: boolean;
    }
    export interface ItemsChartSettingsNodeStyle {
        /** Node anchor mode. */
        anchorMode?: ItemsChartNodeAnchorMode;
        anchorStyle?: ItemsChartSettingsNodeAnchorStyle;
        /** Node anchor y position. If not set, initial position will be calculated automatically and conserved.
        The coordinate space is dependant on `anchorMode` value.
        * anchorMode = "Scene" - the value is in scene coordinates.
        * anchorMode = "Display" - the value is in pixels from top-left corner of the chart area. */
        anchorX?: number;
        /** Node anchor y position. If not set, initial position will be calculated automatically and conserved.
        The coordinate space is dependant on `anchorMode` value.
        * anchorMode = "Scene" - the value is in scene coordinates.
        * anchorMode = "Fixed" - the value is in pixels from top-left corner of the chart area. */
        anchorY?: number;
        coordinates?: (Array<number>|Array<Array<number>>);
        /** Cursor to show when node is hovered. */
        cursor?: string;
        /** Custom shape settings supplied, if display == "customShape" */
        customShape?: ItemsChartSettingsCustomShape;
        /** Valid values: image, text, roundtext, customShape, line, polygon, circle, droplet  */
        display?: string;
        fillColor?: string;
        image?: string;
        /** Specifies the image cropping method. Valid values are `false` (disable cropping), `true` (default cropping mode), `"crop"`, `"letterbox"` and `"fit"`.  */
        imageCropping?: (string|boolean);
        /** The label text that is displayed below the node. Set to an empty string "" to remove the label if it has been added before.  */
        label?: string;
        labelStyle?: ItemsChartSettingsItemsLayerLabelStyle;
        lineColor?: string;
        lineDash?: Array<number>;
        lineWidth?: number;
        /** Node opacity. */
        opacity?: number;
        radius?: number;
        shadowBlur?: number;
        shadowColor?: string;
        shadowOffsetX?: number;
        shadowOffsetY?: number;
    }
    export interface ItemsChartSettingsNodesLayerStyle {
        /** *
          An "all included" style function.
          @returns - links and nodes that the style function has modified. Or `null` to mark all objects as modified. */
        allObjectsStyleFunction?: (
            /** all nodes that currently loaded on the chart */
            nodes: Array<ItemsChartNode>, 
            /** all links that are currently loaded on the chart */
            links: Array<ItemsChartLink>) => {
                modifiedNodes: Array<ItemsChartNode>;
                modifiedLinks: Array<ItemsChartLink>;
            };
        /** Removed object fadeout time. */
        fadeTime?: number;
        /** style for hidden link hints.  */
        hiddenLinks?: {
            fillColor?: string;
            lineColor?: string;
            lineWidth?: number;
            size?: number;
        };
        /** Items are small UI elements that provide extra information. Items are attached to nodes or links and can display a label, image or both.  */
        item?: BaseSettingsLabelStyle;
        /** Default link style.  */
        link?: ItemsChartSettingsLinkStyle;
        /** Link radius auto distribution method. */
        linkAutoScaling?: string;
        /** The class rules to apply individual style for link subset. Use known CSS class definition practice.
        Define one or more classes by specifying name and style and apply those by node definition. If multiple
        classes applied separate them with space and class rules will cascade in order of class definition.  */
        linkClasses?: Array<{
                /** Class name  */
                className?: string;
                /** Style settings  */
                style?: ItemsChartSettingsLinkStyle;
            }>;
        /** Link decorations are not painted if link is shorter than this. */
        linkDecorationMinSize?: number;
        /** Link decoration size calculated as a product of the link radius and scale factor. The value lower than linkDecorationMinSize will take no effect. */
        linkDecorationScale?: number;
        /** Link details like labels, items are hidden if link width in pixels is below this value. */
        linkDetailMinSize?: number;
        /** Link details like labels, items are not rendered if chart zoom is below this value. */
        linkDetailMinZoom?: number;
        /** Additional style to apply when a link is hovered.  */
        linkHovered?: ItemsChartSettingsLinkStyle;
        /** Link text style  */
        linkLabel?: ItemsChartSettingsItemsLayerLabelStyle;
        /** Base node size of link label that scales with link size. */
        linkLabelScaleBase?: number;
        /** Link length auto distribution method. */
        linkLengthAutoScaling?: string;
        /** Min and max value of link length before zooming is applied. */
        linkLengthExtent?: [number, number];
        /** Min and max value of link half-width before zooming is applied. */
        linkRadiusExtent?: [number, number];
        /** An object defining one or more functions used to calculate node rendering style.
        Structure: { 'rule1':function1(nodeObj), 'rule2':function2(nodeObj) }
        The functions are executed in lexicographic order whenever node data or links change.
        Each function can modify the nodeObj to add specific style elements.
        @deprecated - use linkStyleFunction instead */
        linkRules?: Dictionary<(node: ItemsChartLink) => void>;
        linkSelected?: ItemsChartSettingsLinkStyle;
        /** Link strength auto distribution method. */
        linkStrengthAutoScaling?: string;
        /** Min and max value for link strength. */
        linkStrengthExtent?: [number, number];
        /** A a style function for links. Will be called whenever a link property or data has changed.
        Use to dynamically set link style fields. */
        linkStyleFunction?: (node: ItemsChartLink) => void;
        /** Distance between multiple links between two nodes. */
        multilinkSpacing?: number;
        /** Default node style.  */
        node?: ItemsChartSettingsNodeStyle;
        /** Default node  anchor style.  */
        nodeAnchor?: ItemsChartSettingsNodeAnchorStyle;
        /** Controls automatic node scaling. */
        nodeAutoScaling?: string;
        /** The class rules to apply individual style for node subset. Use known CSS class definition practice.
        Define one or more classes by specifying name and style and apply those by node definition. If multiple
        classes applied separate them with space and class rules will cascade in order of class definition.  */
        nodeClasses?: Array<{
                /** Class name  */
                className?: string;
                /** Style settings  */
                style?: ItemsChartSettingsNodeStyle;
            }>;
        /** Node details like labels, items, images are hidden if node width in pixels is below this value. */
        nodeDetailMinSize?: number;
        /** Node details like labels, items, images are not rendered if chart zoom is below this value. */
        nodeDetailMinZoom?: number;
        /** Additional style to apply when node is expanded.  */
        nodeExpanded?: ItemsChartSettingsNodeStyle;
        /** Additional style to apply when node is focused.  */
        nodeFocused?: ItemsChartSettingsNodeStyle;
        /** Additional style to apply when a node is hovered.  */
        nodeHovered?: ItemsChartSettingsNodeStyle;
        /** Node label style.  */
        nodeLabel?: ItemsChartSettingsItemsLayerLabelStyle;
        /** Base node size of node label that scales with node size. */
        nodeLabelScaleBase?: number;
        /** Additional style to apply when a node position is locked.  */
        nodeLocked?: ItemsChartSettingsNodeStyle;
        /** Additional style to apply when node data is not yet loaded.  */
        nodeNotLoaded?: ItemsChartSettingsNodeStyle;
        /** Min and max value of node radius, before zooming is applied. */
        nodeRadiusExtent?: [number, number];
        /** An object defining one or more functions used to calculate node rendering style.
        See see::examples/style/round-image-nodes.html::round image nodes:: example. 
        @deprecated - use nodeStyleFunction instead */
        nodeRules?: Dictionary<(node: ItemsChartNode) => void>;
        nodeSelected?: ItemsChartSettingsNodeStyle;
        /** A a style function for nodes. Will be called whenever a node property or data has changed.
        Use to dynamically set node style fields. */
        nodeStyleFunction?: (node: ItemsChartNode) => void;
        /** Color for fade out animation of removed objects. */
        removedColor?: string;
        /** Whether to set actual node radius zoom-dependent instead of always fixed.  */
        scaleObjectsWithZoom?: boolean;
        selection?: {
            fillColor?: string;
            sizeConstant?: number;
            sizeProportional?: number;
        };
    }
    export interface LinearChartSeriesStackData {
        config: LinearChartSettingsStack;
        data: Array<LinearChartSeriesStackDataItem>;
        name: string;
    }
    export interface LinearChartSeriesStackDataItem {
        config: LinearChartSettingsSeries;
        name: string;
        values: {
            avg: number;
            change: number;
            count: number;
            first: number;
            last: number;
            max: number;
            min: number;
            sum: number;
        };
    }
    export interface LinearChartSettingsArea {
        /** Height of the chart. If undefined the chart height will adapt to container element. */
        height?: number;
        left?: number;
        /** The maximum chart height. Chart will not resize below this. */
        maxHeight?: number;
        /** The maximum chart width. The chart will not resize below this */
        maxWidth?: number;
        /** The minimum chart height. Chart will not resize below this. */
        minHeight?: number;
        /** The minimum chart width. The chart will not resize below this */
        minWidth?: number;
        /** Area style.  */
        style?: LinearChartSettingsAreaStyle;
        top?: number;
        /** Width of the chart. If undefined the chart width will adapt to container element. */
        width?: number;
    }
    export interface LinearChartSettingsAreaStyle {
        /** Background fill color of chart area */
        fillColor?: string;
        /** Background image of  chart area. */
        image?: string;
        /** Style settings when there is no data to display.  */
        noData?: {
            fillColor?: string;
            /** Image to show when there is no data to display. */
            image?: string;
        };
        overlayColor?: string;
        /** Zoom In/Zoom Out animation highlight settings.  */
        zoomHighlight?: {
            /** Cross fade in duration. */
            fadeCross?: number;
            /** Fade in duration. */
            fadeIn?: number;
            /** Fade in duration. */
            fadeOut?: number;
            fillColor?: string;
        };
        /** Zoom highlight style after zoom animation is finished.  */
        zoomHighlightInactive?: {
            fillColor?: string;
        };
    }
    export interface LinearChartSettingsCandleStickMotionStyle {
        /** LHOC pattern style when body part excluded  */
        bar?: {
            lineColor?: string;
            lineDash?: Array<number>;
            lineWidth?: number;
            shadowBlur?: number;
            shadowColor?: string;
            shadowOffsetX?: number;
            shadowOffsetY?: number;
        };
        /** LHOC pattern style when body part included. Line and shadow properties relevant to candlestick outline including body and shadow part.  */
        candlestick?: {
            fillColor?: string;
            /** Candlestick outline color. Including item body outline and shadow stroke style.  */
            lineColor?: string;
            lineDash?: Array<number>;
            lineWidth?: number;
            shadowBlur?: number;
            shadowColor?: string;
            shadowOffsetX?: number;
            shadowOffsetY?: number;
        };
    }
    export interface LinearChartSettingsHighlightStyle {
        fadeCross?: number;
        /** Fade in duration. */
        fadeIn?: number;
        /** Fade out duration. */
        fadeOut?: number;
        fillColor?: string;
    }
    export interface LinearChartSettingsInfoPopup {
        /** Advanced settings relevant to info popup appearance. */
        advanced?: {
            /** Create custom info contents to display in info popup. */
            contentsFunction?: (
                /** Data for the info popup */
                data: Array<LinearChartSeriesStackData>, 
                /** The currently active series object */
                series: any) => string;
            /** Info popup scope. */
            scope?: string;
            /** Whether to show only the series under cursor in info popup.  */
            showOnlyHoveredSeries?: boolean;
        };
        /** List of aggregations for on-screen selection. Available aggregations: sum (default), count, first, last, min, max, avg, change */
        aggregations?: Array<string>;
        /** Show/hide info popup  */
        enabled?: boolean;
        /** Whether to show series with no data in hovered time period.  */
        showNoData?: boolean;
        /** Info popup style.  */
        style?: {
            /** Highlight style  */
            highlight?: LinearChartSettingsHighlightStyle;
        };
        /** Prepare custom format values to display in info popup. See see::api-reference/settings/series/::series:: for available settings. */
        valueFormatterFunction?: (
            /** object containing {sum, min, max, first, last, count, avg, change} */
            values: any, 
            /** series object for the value */
            series: any) => string;
    }
    export interface LinearChartSettingsInteractionScrolling {
        /** Enables/Disables scrolling.  */
        enabled?: boolean;
        /** How far to scroll when Left or Right keys are pressed. Multiples of chart width. */
        keyboardScrollingFactor?: number;
        /** Scrolling friction coefficient (chartWidth/ms^2). */
        kineticFriction?: number;
        /** Whether to use scrolling by full page instead of kinetic scrolling.  */
        swipePageFlipping?: boolean;
    }
    export interface LinearChartSettingsLegend {
        /** Settings to configure the legend marker appearance if disabled series corresponded. */
        advanced?: {
            /** Style for legend entry in case when disabled series presented.  */
            disabledSeries?: {
                fillColor?: string;
                lineColor?: string;
                textColor?: string;
            };
            /** Background color for selected legend entry. */
            selectedBackground?: string;
            /** Border color for selected legend entry. */
            selectedBorder?: string;
        };
        /** Show/hide chart legend.  */
        enabled?: boolean;
        /** Whether to order entries to get possibly equal number of items into columns or rows. If false, once the row or column is full of entries,
        the next element will be first in the new row or column/rows.  */
        equalizeRowsColumns?: boolean;
        /** Maximum height of the legend. If null, all available vertical space of chart will be consumed to set as much entries as possible.
        It coincides with the chart height if legend panel side is on a left or right. */
        height?: number;
        /** Vertical space between the lines of text. */
        lineSpacing?: number;
        /** Margin around each legend entry. */
        margin?: number;
        /** Visual element of legend entry with appropriate style to a slice color it corresponds. The content of each legend marker is the
        same as info popup appearing while hovering on slice.  */
        marker?: BaseSettingsLegendMarker;
        /** Max number of symbols used in one line of text that applies to any legend entry. */
        maxLineSymbols?: number;
        /** Max number of columns. Use in conjunction with side parameter under the legend panel should be right or left in order to arrange entries by columns. */
        numberOfColumns?: number;
        /** Max number of rows. Use in conjunction with side parameter under the legend panel that should be set as bottom or top in order to arrange entries by rows. */
        numberOfRows?: number;
        /** Padding around each entry text and marker. */
        padding?: number;
        /** Legend enclosing panel settings.  */
        panel?: BaseSettingsLegendPanel;
        /** Text settings displaying in legend entries.  */
        text?: {
            fillColor?: string;
            font?: string;
        };
        /** Maximum width of the legend. If null, all available horizontal space of chart will be consumed to set as much entries as possible.
        It coincides with the chart width if legend panel side is on a top or bottom. */
        width?: number;
    }
    export interface LinearChartSettingsLocalization {
        /** Text used on menu close button.  */
        closeButton?: string;
        /** Error message when data request has failed.  */
        dataRequestFailed?: string;
        /** Message to show when data loading is in progress.  */
        loadingLabel?: string;
        /** Text to show when there is no data to display.  */
        noDataLabel?: string;
        /** Strings used in toolbars.  */
        toolbar?: LinearChartSettingsLocalizationToolbar;
        /** Map from unit prefix to multiplier. Used for value axis formatting. */
        valueUnits?: Dictionary<number>;
    }
    export interface LinearChartSettingsLocalizationToolbar {
        backButton?: string;
        backTitle?: string;
        exportButton?: string;
        exportCSV?: string;
        exportJpeg?: string;
        exportPDF?: string;
        exportPNG?: string;
        exportTitle?: string;
        exportXLS?: string;
        fullscreenButton?: string;
        fullscreenTitle?: string;
        /** Linear mode button text.  */
        linButton?: string;
        /** Lin/Log button title.  */
        linLogTitle?: string;
        /** Logarithmic mode button text.  */
        logButton?: string;
        zoomoutButton?: string;
        zoomoutTitle?: string;
    }
    export interface LinearChartSettingsSeries {
        /** Cluster identifier. Columns with the same cluster id will be placed in same cluster.  */
        cluster?: string;
        /** Data manipulation settings used for default series. */
        data?: LinearChartSettingsSeriesData;
        /** Enable/disable series.  */
        enabled?: boolean;
        id?: string;
        /** Name to show in the info popup. The same value is also used in the legend unless `nameLegend` is also set.  */
        name?: string;
        /** Name to show in the legend. If not specified, value from the `name` property is shown.  */
        nameLegend?: string;
        /** Whether to show the series name in legend and info popup.  */
        showInLegend?: boolean;
        /** Stack identifier. Series with same stack ID are placed in the same stack. Define a stack with the same identifier to tune the stack.  */
        stack?: string;
        /** Custom style based on series type. See see::api-reference/settings/chartTypes/::available types::.  */
        style?: {
            fillColor?: string;
            lineColor?: string;
        };
        /** Series type. */
        type?: string;
        /** Id of value axis to use. See see::api-reference/settings/valueAxis/::value axis:: for more info.  */
        valueAxis?: string;
    }
    export interface LinearChartSettingsSeriesCandleStick {
        /** Cluster identifier. Columns with the same cluster id will be placed in same cluster.  */
        cluster?: string;
        /** Data manipulation settings used for default series. */
        data?: LinearChartSettingsSeriesCandleStickData;
        /** Enable/disable series.  */
        enabled?: boolean;
        id?: string;
        /** Info popup localizeable strings  */
        localization?: {
            close?: string;
            high?: string;
            low?: string;
            open?: string;
        };
        /** Name to show in the info popup. The same value is also used in the legend unless `nameLegend` is also set.  */
        name?: string;
        /** Name to show in the legend. If not specified, value from the `name` property is shown.  */
        nameLegend?: string;
        /** Whether to show the series name in legend and info popup.  */
        showInLegend?: boolean;
        /** Stack identifier. Series with same stack ID are placed in the same stack. Define a stack with the same identifier to tune the stack.  */
        stack?: string;
        /** Custom style based on series type. See see::api-reference/settings/chartTypes/::available types::.  */
        style?: {
            /** Item style when open is higher than close  */
            decrease?: LinearChartSettingsCandleStickMotionStyle;
            /** Item style when open is smaller than close  */
            increase?: LinearChartSettingsCandleStickMotionStyle;
            /** Item left and right padding */
            padding?: [number, number];
            /** Candlestick item representation pattern where difference is wethter to show body part */
            pattern?: string;
        };
        /** Series type. */
        type?: string;
        /** Id of value axis to use. See see::api-reference/settings/valueAxis/::value axis:: for more info.  */
        valueAxis?: string;
    }
    export interface LinearChartSettingsSeriesCandleStickData {
        /** Prepare displaying value after data aggregation. */
        aggregatedValueFunction?: (
            /** aggregated value that is about to be displayed */
            value: any, 
            /** time display unit time stamp in ms */
            time: any, 
            /** display unit */
            units: any) => any;
        /** Aggregation function to use. Used when data source does not provide data in needed display unit. */
        aggregation?: string;
        close?: number;
        field?: any;
        high?: number;
        /** Index in value array to use. */
        index?: number;
        low?: number;
        /** Method used to fill in time intervals that have no data. Used only for line series. */
        noDataPolicy?: string;
        open?: number;
        /** Data source to use if multiple data sources are available. */
        source?: string;
        /** Before data aggregation prepare value taken from entry in data values array. */
        valueFunction?: (
            /** entry in data values array */
            data: any) => any;
    }
    export interface LinearChartSettingsSeriesColumns {
        /** Cluster identifier. Columns with the same cluster id will be placed in same cluster.  */
        cluster?: string;
        /** Data manipulation settings used for default series. */
        data?: LinearChartSettingsSeriesData;
        /** Enable/disable series.  */
        enabled?: boolean;
        id?: string;
        /** Name to show in the info popup. The same value is also used in the legend unless `nameLegend` is also set.  */
        name?: string;
        /** Name to show in the legend. If not specified, value from the `name` property is shown.  */
        nameLegend?: string;
        /** Whether to show the series name in legend and info popup.  */
        showInLegend?: boolean;
        /** Stack identifier. Series with same stack ID are placed in the same stack. Define a stack with the same identifier to tune the stack.  */
        stack?: string;
        /** Default column style.  */
        style?: {
            /** Depth for column. Use it to achieve 3D effect. */
            depth?: number;
            /** Brightness applied to depth components. */
            depthBrightness?: number;
            /** Fill color. */
            fillColor?: string;
            /** Fill gradient. Allows building a gradient fill, bound to values. Contains array of value-color pairs. 
            For example: [[-20, 'rgba(0,0,255,0.4)'],[30,'rgba(255,0,0,0.7)']]. */
            fillGradient?: GradientDefinition;
            /** A linear gradient for color change along a line between the column bottom and upper side.
            Specify "1" for no gradiend. Values 0..` will make the bottom part of columns slightly darker. */
            gradient?: number;
            /** Outline color. */
            lineColor?: string;
            /** Array of line dash pattern to have a dashed line. The array contains length of dash followed by length of space in pixels.
            A sequence of multiple dash-space values is supported.  */
            lineDash?: Array<number>;
            /** Outline width in px. */
            lineWidth?: number;
            /** Minimum height of a column in px. */
            minHeight?: number;
            /** Padding for column. 0th element - left padding, 1st element - right padding. */
            padding?: [number, number];
            previewLineColor?: string;
            /** Shadow blur effect range. */
            shadowBlur?: number;
            /** Shadow color of column. If undefined, no shadow will be applied. Leave empty to use default shadow or set your own shadow color. */
            shadowColor?: string;
            /** Shadow direction, x component. */
            shadowOffsetX?: number;
            /** Shadow direction, y component. */
            shadowOffsetY?: number;
        };
        /** Series type. */
        type?: string;
        /** Id of value axis to use. See see::api-reference/settings/valueAxis/::value axis:: for more info.  */
        valueAxis?: string;
    }
    export interface LinearChartSettingsSeriesData {
        /** Prepare displaying value after data aggregation. */
        aggregatedValueFunction?: (
            /** aggregated value that is about to be displayed */
            value: any, 
            /** time display unit time stamp in ms */
            time: any, 
            /** display unit */
            units: any) => any;
        /** Aggregation function to use. Used when data source does not provide data in needed display unit. */
        aggregation?: string;
        field?: any;
        /** Index in value array to use. */
        index?: number;
        /** Method used to fill in time intervals that have no data. Used only for line series. */
        noDataPolicy?: string;
        /** Data source to use if multiple data sources are available. */
        source?: string;
        /** Before data aggregation prepare value taken from entry in data values array. */
        valueFunction?: (
            /** entry in data values array */
            data: any) => any;
    }
    export interface LinearChartSettingsSeriesLines {
        /** Cluster identifier. Columns with the same cluster id will be placed in same cluster.  */
        cluster?: string;
        /** Data manipulation settings used for default series. */
        data?: LinearChartSettingsSeriesData;
        /** Enable/disable series.  */
        enabled?: boolean;
        id?: string;
        /** Name to show in the info popup. The same value is also used in the legend unless `nameLegend` is also set.  */
        name?: string;
        /** Name to show in the legend. If not specified, value from the `name` property is shown.  */
        nameLegend?: string;
        /** Whether to show the series name in legend and info popup.  */
        showInLegend?: boolean;
        /** Stack identifier. Series with same stack ID are placed in the same stack. Define a stack with the same identifier to tune the stack.  */
        stack?: string;
        /** Default style for line type series.  */
        style?: {
            /** Depth for column. Use it to achieve 3D effect. */
            depth?: number;
            /** Color to fill area between the line and the zero line. */
            fillColor?: string;
            /** Fill gradient. Allows building a gradient fill, bound to values. Contains array of value-color pairs. 
            For example: [[-20, 'rgba(0,0,255,0.4)'],[30,'rgba(255,0,0,0.7)']]. */
            fillGradient?: GradientDefinition;
            lineColor?: string;
            /** Array of line dash pattern to have a dashed line. The array contains length of dash followed by length of space in pixels.
            A sequence of multiple dash-space values is supported.  */
            lineDash?: Array<number>;
            /** Width of the line. */
            lineWidth?: number;
            /** Marker highlight data points on line. They can be in different sizes, shapes and colors.  */
            marker?: {
                /** Marker fill color. Note that it must be set to the preferred color in order to display them. */
                fillColor?: string;
                /** Marker shapes. */
                shape?: string;
                /** The width of the marker. In case when circle - interpreted as the diameter. */
                width?: number;
            };
            /** Shadow blur radius. */
            shadowBlur?: number;
            /** The shadow color of line. */
            shadowColor?: string;
            /** Shadow direction, x component. */
            shadowOffsetX?: number;
            /** Shadow direction, y component. */
            shadowOffsetY?: number;
            /** Whether to draw smoothed line.  */
            smoothing?: boolean;
            /** Whether to draw the line using horizontal segments instead of oblique.  */
            steps?: boolean;
        };
        /** Series type. */
        type?: string;
        /** Id of value axis to use. See see::api-reference/settings/valueAxis/::value axis:: for more info.  */
        valueAxis?: string;
    }
    export interface LinearChartSettingsStack {
        /** The display name in info popup.  */
        name?: string;
        /** Whether to separate negative values.  */
        separateNegativeValues?: boolean;
        /** Different representation of stacked series values. */
        type?: string;
    }
    export interface LinearChartSettingsValueAxis {
        /** Whether to show vertical line along value axis  */
        axisLine?: boolean;
        /** Show/hide value axis.  */
        enabled?: boolean;
        /** Whether to show horizontal grid lines. Specifying `null` means that only the first value axis will show the horizontal lines,
        all other axis will not.  */
        hgrid?: boolean;
        /** Whether to use logarithmic scale.  */
        logScale?: boolean;
        /** Fixed maximum value for value axis. If not set it will be computed automatically from visible data and zeroLine settings. */
        maxValue?: number;
        /** Fixed minimum value for value axis. If not set it will be computed automatically from visible data and zeroLine settings. */
        minValue?: number;
        /** Location of the value axis. */
        position?: string;
        scaleAdjustmentAnimation?: string;
        /** Scale adjustment animation duration. */
        scaleAdjustmentAnimationDelay?: number;
        /** This tolerance specifies how big that part is as fraction of total chart height. When part of the vertical space
        is not used chart scale is automatically adjusted. */
        scaleAdjustmentTolerance?: number;
        /** Smallest difference between two labels. For example, use 1 to disallow the labels to go into fractions. */
        scaleMinStep?: number;
        /** Difference between two values on the axis. If not set (default), will be automatically calculated from chart height, min,
        max value and style.labelSpacing. */
        scaleStep?: number;
        /** Value axis side in chart */
        side?: string;
        /** Fixed width of the value axis. If not set it will be computed automatically from font size. */
        size?: number;
        /** Style for parts of value axis.  */
        style?: {
            /** Rendering style for the vertical line along value axis.  */
            axisLine?: BaseSettingsLineStyle;
            /** Base line settings. It is the horizontal line showing zero value.  */
            baseLine?: LinearChartSettingsValueAxisBaseLineStyle;
            /** Horizontal grid lines.  */
            hgrid?: BaseSettingsLineStyle;
            /** Distance between value axis labels. */
            labelSpacing?: number;
            /** Value axis tick lines style.  */
            tick?: BaseSettingsLineStyle;
            /** Title text for the value axis.  */
            title?: LinearChartSettingsValueAxisTitleStyle;
            /** Value axis label rendering settings.  */
            valueLabel?: LinearChartSettingsValueAxisValueLabelStyle;
        };
        /** Provides the ability to draw threshold guidelines and fill background areas for certain values. For example, this can be used
        to highlight an area that exceeds certain limit. */
        thresholds?: Array<LinearChartSettingsValueAxisThreshold>;
        /** Title text for the value axis.  */
        title?: string;
        /** Prepare custom format values to display in value axis. If using this, also set the `size` parameter to accommodate your label size. */
        valueFormatterFunction?: (
            /** numerical value to display */
            value: number, 
            /** name of multiplier - 'K' for thousands, 'M' for millions */
            unitName: string, 
            /** multiplier value - 1000 for thousands, 1 000 000 for millions */
            unitValue: number, 
            /** value string that is displayed by default */
            name: string) => string;
        /** Zero line. */
        zeroLine?: string;
    }
    export interface LinearChartSettingsValueAxisBaseLineStyle {
        depthColor?: string;
        lineColor?: string;
        lineDash?: Array<number>;
        lineDepth?: number;
        lineWidth?: number;
    }
    export interface LinearChartSettingsValueAxisThreshold {
        /** Specifies the bottom bound of the threshold area.  */
        from?: number;
        /** Threshold placement in relation to series data. */
        position?: string;
        /** Describes the visual style for the threshold guidelines and area.  */
        style?: {
            /** Specifies the fill color for the threshold area. If multiple areas overlap, this should specify an `rgba()` color with transparency. 
            If 'null' fill color will not be applied. */
            fillColor?: string;
            /** Specifies the line color for the upper and lower bounds. If `null`, the lines will not be drawn.  */
            lineColor?: string;
            /** Array of line dash pattern to have a dashed line. The array contains length of dash followed by length of space in pixels.
            A sequence of multiple dash-space values is supported.  */
            lineDash?: Array<number>;
            /** Specifies the width of the boundary lines.  */
            lineWidth?: number;
        };
        /** Specifies the upper bound of the threshold area.  */
        to?: number;
    }
    export interface LinearChartSettingsValueAxisTitleStyle {
        /** Text alignment. */
        align?: string;
        alignment?: string;
        /** The angle at which the label are rotated */
        angle?: number;
        /** Ratio between label sizes in different dimensions */
        aspectRatio?: number;
        /** Background style including fill color.  */
        backgroundStyle?: BaseSettingsBackgroundStyle;
        /** Radius of item border. Similar to CSS border radius property. Zero radius will show a rectangle */
        borderRadius?: number;
        fillColor?: string;
        font?: string;
        /** Label image. */
        image?: string;
        /** Slicing to use tiled images. Array of 4 values: [left, top, width, height]  */
        imageSlicing?: [number, number, number, number];
        /** Vertical space between the lines of text. In multiples of text line height. */
        lineSpacing?: number;
        /** Margin around label text */
        margin?: number;
        /** Maximum width of the label. */
        maxWidth?: number;
        /** Padding between item content and item border. */
        padding?: number;
        reverseDirection?: boolean;
        shadowBlur?: number;
        shadowColor?: string;
        shadowOffsetX?: number;
        shadowOffsetY?: number;
        /** Label text.  */
        text?: string;
        /** Text style including fill color and font.  */
        textStyle?: BaseSettingsTextStyle;
    }
    export interface LinearChartSettingsValueAxisValueLabelStyle {
        /** Text alignment. */
        align?: string;
        /** The angle at which the label are rotated */
        angle?: number;
        /** Ratio between label sizes in different dimensions */
        aspectRatio?: number;
        /** Background style including fill color.  */
        backgroundStyle?: BaseSettingsBackgroundStyle;
        /** Radius of item border. Similar to CSS border radius property. Zero radius will show a rectangle */
        borderRadius?: number;
        fillColor?: string;
        font?: string;
        /** Label image. */
        image?: string;
        /** Slicing to use tiled images. Array of 4 values: [left, top, width, height]  */
        imageSlicing?: [number, number, number, number];
        /** Vertical space between the lines of text. In multiples of text line height. */
        lineSpacing?: number;
        /** Margin around label text */
        margin?: number;
        /** Maximum width of the label. */
        maxWidth?: number;
        /** Padding between item content and item border. */
        padding?: number;
        shadowBlur?: number;
        shadowColor?: string;
        shadowOffsetX?: number;
        shadowOffsetY?: number;
        /** Label text.  */
        text?: string;
        /** Text style including fill color and font.  */
        textStyle?: BaseSettingsTextStyle;
    }
    export interface NetChartBarSettingsLocalizationToolbar {
        backButton?: string;
        backTitle?: string;
        exportButton?: string;
        exportCSV?: string;
        exportJpeg?: string;
        exportPDF?: string;
        exportPNG?: string;
        exportTitle?: string;
        exportXLS?: string;
        fitButton?: string;
        fitTitle?: string;
        freezeButton?: string;
        freezeTitle?: string;
        fullscreenButton?: string;
        fullscreenTitle?: string;
        rearrangeButton?: string;
        rearrangeTitle?: string;
        unfreezeTitle?: string;
        zoomoutButton?: string;
        zoomoutTitle?: string;
    }
    export interface NetChartBarSettingsToolbar {
        /** Toolbar align. Note that it can be overridden for individual items using item.align. Also Use 'top' or 'bottom' 
        sides in conjunction with 'left', 'right' align or use 'left', 'right' sides with 'top', 'bottom'. */
        align?: string;
        /** Whether to show back button in toolbar.  */
        back?: boolean;
        /** CSS class name for the toolbar HTML panel.  */
        cssClass?: string;
        /** Show/hide toolbar.  */
        enabled?: boolean;
        /** Whether to show export dropdown in toolbar.  */
        export?: boolean;
        /** A list of user defined items to show in toolbar.  */
        extraItems?: Array<(string|BaseSettingsToolbarItem)>;
        /** A list of toolbar items. Use it to completely override the items in toolbar.  */
        items?: Array<(string|BaseSettingsToolbarItem)>;
        /** Toolbar location inside chart. */
        location?: string;
        /** Whether to show or hide labels next to toolbar items by default. Note that it can be overridden for individual items using item.showLabels.  */
        showLabels?: boolean;
        /** Toolbar placement side. Note that it can be overridden for individual items using item.side. */
        side?: string;
        /** Whether to show the zoom out button.  */
        zoomOut?: boolean;
    }
    export interface NetChartFocusNode {
        actionId: number;
        collapsed: boolean;
        expanded: boolean;
        hidden: boolean;
        id: any;
        initial: boolean;
        relevance: number;
        stopped: boolean;
    }
    export interface NetChartDataObject {
        error?: string;
        links: Array<NetChartDataObjectLink>;
        nodes: Array<NetChartDataObjectNode>;
    }
    export interface NetChartDataObjectLink {
        from: string;
        /** The unique identifier of the node.  */
        id?: string;
        style?: NetChartDataObjectStyle;
        to: string;
        value?: number;
    }
    export interface NetChartDataObjectNode {
        error?: string;
        /** The unique identifier of the node.  */
        id: string;
        loaded: boolean;
        style?: NetChartDataObjectStyle;
        value?: number;
        x?: number;
        y?: number;
    }
    export interface NetChartDataObjectStyle {
        label?: string;
    }
    export interface NetChartSettings {
        advanced?: ItemsChartSettingsAdvanced;
        /** Chart area related settings. */
        area?: NetChartSettingsArea;
        assetsUrlBase?: string;
        /** Element of the page where the chart will be inserted. For example a div. Any contents of the element will be cleared.
        Note that a single element can host only one chart.  */
        container?: (string|HTMLElement);
        credits?: BaseSettingsCredits;
        data?: Array<NetChartSettingsData>;
        /** The events used to handle user interaction with UI elements. See see::interactivity/::events:: for more info. */
        events?: BaseSettingsEvents;
        /** Configurable conditions to filter the raw data values for subset of drawing nodes and links. */
        filters?: {
            /** Determine if link should be displayed. Invoked whenever a new link is about to be shown. */
            linkFilter?: (
                /** link data object */
                linkData: any, 
                /** data object representing node where the link begins */
                fromNodeData: any, 
                /** data object representing node where the link ends */
                toNodeData: any) => boolean;
            /** Function called whenever there are more than one link between two nodes. */
            multilinkProcessor?: (
                /** array of link data objects */
                arrayOfLinkData: any, 
                /** data object representing node where the links begins */
                fromData: any, 
                /** data object representing node where the links ends */
                toData: any) => any;
            /** Determine if node should be displayed. Invoked whenever a new node is about to be shown. */
            nodeFilter?: (
                /** node data object */
                nodeData: any, 
                /** array of link data objects */
                arrayOfLinkData: any) => boolean;
            /** Select links to show from a node. */
            nodeLinksProcessor?: (
                /** node data object */
                nodeData: any, 
                /** array of link data objects. All links are connected to the node */
                links: any) => any;
        };
        /** Info popup for item - meaning links or nodes - with configurable content rendered. */
        info?: {
            /** Show/hide info popup  */
            enabled?: boolean;
            /** Returns html string to display in passed links info popup. */
            linkContentsFunction?: (
                /** link object */
                link: any) => any;
            /** Returns html string to display in passed nodes info popup. */
            nodeContentsFunction?: (
                /** node object */
                node: any) => any;
        };
        /** Customise chart resize handles or animation duration settings. */
        interaction?: NetChartSettingsInteraction;
        /** Adjustable settings to get desired net chart layout style and animation while and before interacting. */
        layout?: NetChartSettingsLayout;
        /** The chart legend representing classes attached to nodes or links. Note that it's a current grouping alternative. */
        legend?: NetChartSettingsLegend;
        /** Configurable link menu with option to specify a range of displaying buttons. */
        linkMenu?: ItemsChartSettingsLinkMenu;
        /** Localizeable strings including export type options and useful default buttons used for chart interaction.
        Buttons like to navigate back, set the chart on full screen and others. */
        localization?: NetChartSettingsLocalization;
        /** Controls the dynamic layout appearance and interaction associated with initial and focal nodes. */
        navigation?: NetChartSettingsNavigation;
        /** Configurable node menu with option to specify a range of displaying buttons. */
        nodeMenu?: ItemsChartSettingsNodeMenu;
        /** Parent chart to place this chart as subchart.
        Use area.left, area.top, area.width, area.height to position the subchart within parent chart. */
        parentChart?: BaseApi;
        /** Chart style settings. */
        style?: ItemsChartSettingsNodesLayerStyle;
        /** Theme to apply. Should contain an javascript object with additional settings.  */
        theme?: NetChartSettings;
        /** The chart's main title. */
        title?: BaseSettingsTitle;
        /** Adjustable settings to manage default and custom toolbar items, as well as toolbar overall appearance. */
        toolbar?: NetChartBarSettingsToolbar;
    }
    export interface NetChartSettingsArea {
        /** The center of the chart. Fraction of chart width. 0 = left side, 1 = right side. */
        centerX?: number;
        /** The center of the chart. Fraction of chart height, 0 = top, 1 = botom. */
        centerY?: number;
        /** Height of the chart. If undefined the chart height will adapt to container element. */
        height?: number;
        left?: number;
        /** The maximum chart height. Chart will not resize below this. */
        maxHeight?: number;
        /** The maximum chart width. The chart will not resize below this */
        maxWidth?: number;
        /** The minimum chart height. Chart will not resize below this. */
        minHeight?: number;
        /** The minimum chart width. The chart will not resize below this */
        minWidth?: number;
        /** Inner bottom padding, nodes will avoid this area.
        If the value is <= 1 then the value represents the fraction from the chart width. 
        Otherwise it represents the padding value in pixels. */
        paddingBottom?: number;
        /** Inner left padding, nodes will avoid this area.
        If the value is <= 1 then the value represents the fraction from the chart width. 
        Otherwise it represents the padding value in pixels. */
        paddingLeft?: number;
        /** Inner right padding, nodes will avoid this area.
        If the value is <= 1 then the value represents the fraction from the chart width. 
        Otherwise it represents the padding value in pixels. */
        paddingRight?: number;
        /** Inner top padding, nodes will avoid this area.
        If the value is <= 1 then the value represents the fraction from the chart width. 
        Otherwise it represents the padding value in pixels. */
        paddingTop?: number;
        /** Area style.  */
        style?: BaseSettingsAreaStyle;
        top?: number;
        /** Width of the chart. If undefined the chart width will adapt to container element. */
        width?: number;
    }
    export interface NetChartSettingsData {
        /** Count of caching items including only links and nodes. */
        cacheSize?: number;
        /** Load more chart data. */
        dataFunction?: (
            /** loading nodes */
            nodes: any, 
            /** callback function to execute when data arrived correctly */
            success: (data: NetChartDataObject) => void, 
            /** callback function to execute when error occure while loading data */
            fail: (result: BaseDataErrorResponse) => void) => void;
        /** Data loading format. Currently only JSON supported. */
        format?: string;
        /** Data id used for series to reference specific data source.  */
        id?: string;
        /** Max number of parallel data requests to issue. More requests will result in faster loading, but might put heavy load on server. */
        numberOfParallelRequests?: number;
        /** Delegate that can be used to process data returned by the server for the HTTP request issued by the chart. */
        postprocessorFunction?: (
            /** The raw data received from the server.  */
            data: any) => any;
        /** Whether to load links for all disabled nodes automatically. Otherwise, links will be loaded only when expanding a node.  */
        preloadNodeLinks?: boolean;
        /** Provides the ability to embed chart data directly into the chart configuration.
        Data can be represented by an JavaScript object or a JSON string.  */
        preloaded?: (string|NetChartDataObject);
        /** Specifies the random layout method: grid, tree, uniform. The default is uniform. */
        random?: string;
        randomGridLinkProbability?: number;
        /** Generates random data.  */
        randomLinks?: number;
        /** Generates random data. Specify a value larger than 0 to enable generating random data. */
        randomNodes?: number;
        randomTreeDensity?: number;
        /** Max number of nodes to submit in a single request. */
        requestMaxUnits?: number;
        /** Timeout in milliseconds for data requests. This timeout only applies to HTTP requests issued by the chart directly. */
        requestTimeout?: number;
        /** URL to load more data. URL parameters: from, to, unit */
        url?: string;
        /** List of extra parameters to pass with data URL.  */
        urlParameters?: Array<{
                /** Parameter name. */
                name?: string;
                /** Parameter value. */
                value?: string;
            }>;
    }
    export interface NetChartSettingsInteraction {
        /** Chart animation settings. */
        animation?: {
            /** Duration of hover animation. */
            hoverDuration?: number;
            /** Duration of scroll animation. */
            scrollDuration?: number;
        };
        /** Whether to allow moving nodes around.  */
        nodesMovable?: boolean;
        /** Move chart vertically and horizontally by clicking on the main chart pane and dragging it on any direction. */
        panning?: {
            /** Enables/disables chart panning.  */
            enabled?: boolean;
        };
        resizing?: BaseSettingsResizer;
        /** Select node to expand it or getting path. */
        selection?: NetChartSettingsInteractionSelection;
        /** Zoom in or out by swiping up or down with mouse scroll pad or by using the Zoom-out feature at the top left. */
        zooming?: NetChartSettingsInteractionZooming;
    }
    export interface NetChartSettingsInteractionSelection {
        /** Whether to move nodes outside of screen area.  */
        allowMoveNodesOffscreen?: boolean;
        /** Enable/disable selection.  */
        enabled?: boolean;
        /** Whether to set links selectable.  */
        linksSelectable?: boolean;
        /** Whether to retain nodes location after being moved by the user.  */
        lockNodesOnMove?: boolean;
        /** Whether to set nodes selectable.  */
        nodesSelectable?: boolean;
        /** Max click distance from object that still counts as click on the object. */
        tolerance?: number;
    }
    export interface NetChartSettingsInteractionZooming {
        /** Whether to auto zoom every time user clicks on the chart.  */
        autoZoomAfterClick?: boolean;
        /** Zoom value limits when user zooms in and out. Contains array of [min, max] values. If the network is big, the min value
        is adjusted so that whole network can be shown. */
        autoZoomExtent?: [number, number];
        /** The acceleration of scene movement, when trying to contain all nodes within the view,
        when autozoom is enabled. Increasing the value decreases latency, and makes the animation
        more responsive. Decreasing the value makes the animation more fluid */
        autoZoomPositionEllasticity?: number;
        /** Fraction of the chart to use in auto zoom mode. This governs the white space area around network in auto zoom mode. */
        autoZoomSize?: number;
        /** A double-click on empty space will trigger zoom in by this value. Set to null or false to disable double click zooming. */
        doubleClickZoom?: number;
        /** Whether to zoom by two finger pinch.  */
        fingers?: boolean;
        /** Auto zoom mode on chart initialization. */
        initialAutoZoom?: string;
        /** Sensitivity of wheel zoom. */
        sensitivity?: number;
        /** Whether to zoom by mouse wheel.  */
        wheel?: boolean;
        /** Zoom value limits while in auto-zoom mode. Contains array of [min, max] values. */
        zoomExtent?: [number, number];
        /** Enable/Disable zoom in on double click.  */
        zoomInOnDoubleClick?: boolean;
    }
    export interface NetChartSettingsLayout {
        /** Advanced chart settings. Be advised that they are subject to change, backwards compatibility is not guaranteed. */
        advanced?: {
            adaptiveFreezeTreshold?: number;
        };
        /** Whether to fit network in aspect ratio of chart viewport. Useful for small networks that always fit in chart and are not intended to be zoomed in / out.  */
        aspectRatio?: boolean;
        /** Whether to perform global layout on network changes. Use it for better node placement at the cost of chart slowdown on network changes.  */
        globalLayoutOnChanges?: boolean;
        /** Maximum time to wait for incremental layout to be completed. Note that bigger value will get nicer placement on network updates at the cost of longer delay. */
        incrementalLayoutMaxTime?: number;
        /** Maximum time to wait for initial layout to be completed. Note that bigger value will get nicer placement of big networks at the cost of long initial delay. */
        initialLayoutMaxTime?: number;
        /** Dynamic layout can be stopped faster if no more movement is detected. */
        layoutFreezeMinTimeout?: number;
        /** Dynamic layout is stopped after user is inactive for this time. */
        layoutFreezeTimeout?: number;
        /** Layout mode. */
        mode?: string;
        /** Desired distance between nodes. */
        nodeSpacing?: number;
        /** Desired vertical distance between node rows in the hierarchy layout. */
        rowSpacing?: number;
    }
    export interface NetChartSettingsLegend {
        /** Settings to configure the legend marker appearance if disabled series corresponded. */
        advanced?: {
            /** Style for legend entry in case when disabled series presented.  */
            disabledSeries?: {
                fillColor?: string;
                lineColor?: string;
                textColor?: string;
            };
            /** Background color for selected legend entry. */
            selectedBackground?: string;
            /** Border color for selected legend entry. */
            selectedBorder?: string;
        };
        /** Show/hide chart legend.  */
        enabled?: boolean;
        /** Whether to order entries to get possibly equal number of items into columns or rows. If false, once the row or column is full of entries,
        the next element will be first in the new row or column/rows.  */
        equalizeRowsColumns?: boolean;
        /** Maximum height of the legend. If null, all available vertical space of chart will be consumed to set as much entries as possible.
        It coincides with the chart height if legend panel side is on a left or right. */
        height?: number;
        /** Vertical space between the lines of text. */
        lineSpacing?: number;
        /** Margin around each legend entry. */
        margin?: number;
        /** Visual element of legend entry with appropriate style to a slice color it corresponds. The content of each legend marker is the
        same as info popup appearing while hovering on slice.  */
        marker?: BaseSettingsLegendMarker;
        /** Max number of symbols used in one line of text that applies to any legend entry. */
        maxLineSymbols?: number;
        /** Max number of columns. Use in conjunction with side parameter under the legend panel should be right or left in order to arrange entries by columns. */
        numberOfColumns?: number;
        /** Max number of rows. Use in conjunction with side parameter under the legend panel that should be set as bottom or top in order to arrange entries by rows. */
        numberOfRows?: number;
        /** Padding around each entry text and marker. */
        padding?: number;
        /** Legend enclosing panel settings.  */
        panel?: BaseSettingsLegendPanel;
        /** Text settings displaying in legend entries.  */
        text?: {
            fillColor?: string;
            font?: string;
        };
        /** Maximum width of the legend. If null, all available horizontal space of chart will be consumed to set as much entries as possible.
        It coincides with the chart width if legend panel side is on a top or bottom. */
        width?: number;
    }
    export interface NetChartSettingsLocalization {
        /** Text used on menu close button.  */
        closeButton?: string;
        /** Error message when data request has failed.  */
        dataRequestFailed?: string;
        /** Message to show when data loading is in progress.  */
        loadingLabel?: string;
        /** Node/link menu by using localizeable strings.  */
        menu?: {
            collapse?: string;
            dynaminc?: string;
            expand?: string;
            fixed?: string;
            focus?: string;
            hide?: string;
            unfocus?: string;
        };
        /** Strings used in toolbars.  */
        toolbar?: NetChartBarSettingsLocalizationToolbar;
    }
    export interface NetChartSettingsNavigation {
        /** Whether to auto zoom when a new focus node is added.  */
        autoZoomOnFocus?: boolean;
        /** Expand delay for multi-level expands. When adding a focus node it results in showing multiple levels on nodes. Each level is shown after a short delay. */
        expandDelay?: number;
        /** Whether to expand node on click.  */
        expandOnClick?: boolean;
        /** Whether to limit the number of focus nodes to numberOfFocusNodes. If more nodes are focused, oldest are removed.  */
        focusAutoFadeout?: boolean;
        /** Link distance from focus nodes to show. */
        focusNodeExpansionRadius?: number;
        /** Expansion radius of the oldest (end of the tail) focus node. */
        focusNodeTailExpansionRadius?: number;
        /** Initially visible nodes. Array of node identifiers.  */
        initialNodes?: Array<string>;
        /** Minimal number of focus nodes. Prevents user from removing focus nodes if there are minNumberOfFocusNodes available. */
        minNumberOfFocusNodes?: number;
        /** Navigation mode. */
        mode?: string;
        nodeAutoExpandFilter?: any;
        /** Maximal number of focus nodes. When more focus nodes are added, oldest nodes are removed. */
        numberOfFocusNodes?: number;
    }
    export interface PieChartDataObject {
        afterSum?: number;
        beforeSum?: number;
        id?: string;
        limit?: number;
        name?: string;
        offset?: number;
        subvalues?: Array<PieChartDataObject>;
        sum?: number;
        total?: number;
        value: number;
    }
    export interface PieChartDataObjectRoot {
        afterSum?: number;
        beforeSum?: number;
        error?: string;
        id?: string;
        limit?: number;
        name?: string;
        offset?: number;
        subvalues: Array<PieChartDataObject>;
        sum?: number;
        total?: number;
    }
    export interface PieChartPie {
        active: boolean;
        activeSliceId: string;
        allSlices: Array<PieChartSlice>;
        background: boolean;
        brightness: number;
        colorDistribution: any;
        count: number;
        currentEndAngle: number;
        currentInnerRadius: number;
        currentRadius: number;
        currentStartAngle: number;
        data: any;
        endAngle: number;
        fillColor: string;
        getActiveSlice(): PieChartSlice;
        id: string;
        innerRadius: number;
        loading: boolean;
        offset: number;
        othersSlice: PieChartSlice;
        parentSlice: PieChartSlice;
        previousSlice: PieChartSlice;
        radius: number;
        /** The time when the animator will remove the pie completely.  */
        removeTime: number;
        removed: boolean;
        scrollOffset: number;
        sliceColors: any;
        slices: Array<PieChartSlice>;
        startAngle: number;
        total: number;
        visibleFraction: number;
        x: number;
        y: number;
    }
    export interface PieChartSettings {
        /** Advanced chart settings. Be advised that they are subject to change, backwards compatibility is not guaranteed. */
        advanced?: PieChartSettingsAdvanced;
        /** Chart area related settings. */
        area?: BaseSettingsArea;
        assetsUrlBase?: string;
        /** Element of the page where the chart will be inserted. For example a div. Any contents of the element will be cleared.
        Note that a single element can host only one chart.  */
        container?: (string|HTMLElement);
        credits?: BaseSettingsCredits;
        data?: Array<PieChartSettingsData>;
        /** The events used to handle user interaction with UI elements. See see::interactivity/::events:: for more info. */
        events?: PieChartSettingsEvents;
        /** Configurable conditions to filter the raw data values for subset of drawing slices. */
        filters?: {
            /** Function to filter visible slices. */
            sliceFilter?: (
                /** slice filtering data */
                sliceData: any) => boolean;
        };
        /** Slice icons as an additional element of style to highlight each individual slice or groups. */
        icons?: {
            /** Whether to render icons if smaller than min value of sizeExtent.  */
            autohideWhenTooSmall?: boolean;
            /** Icon placement method */
            placement?: string;
            /** Min and max value of icon size. The icon size is automatically computed from available space.  */
            sizeExtent?: [number, number];
        };
        /** Rising content field while hovering over slice. Content returned in a form of html and is relevant to context of slice hovered. */
        info?: {
            /** Prepare custom info popup contents. May return null and call callback(contents) later.  */
            contentsFunction?: (
                /** slice data including subvalues */
                sliceData: any, 
                /** slice object to apply predefined content */
                slice: any, 
                /** function called to return predefined content */
                callback: (result: string) => void) => string;
            /** Show/hide info popup.  */
            enabled?: boolean;
        };
        /** Configurable interactivity options to navigate among the slices and pie levels to facilitate analysis of the grouped data in different ways. */
        interaction?: PieChartSettingsInteraction;
        /** Label settings related to internal and external slice text and their connectors. */
        labels?: {
            /** Label rotation angle. */
            angle?: number;
            /** Minimal connector length from slice to label. */
            connectorLength?: number;
            /** Whether to show connector lines for labels.  */
            connectors?: boolean;
            /** Show/hide labels.  */
            enabled?: boolean;
            /** Inside label placement method. */
            insideLabel?: string;
            /** Inside label is not shown if the fraction of label that fits inside slice is smaller than this. */
            insideLabelVisibilityFraction?: number;
            /** Min distance between labels, as a fraction of line height. */
            interLabelSpacing?: number;
            /** Outside labels placement method. */
            placement?: string;
        };
        /** The chart legend by additional interactivity to navigate between the slices or hilight each of them. Note that click on entries 
        acts the same way as click on slice and is dependant of chart interaction mode. */
        legend?: PieChartSettingsLegend;
        /** Localizeable strings including export type options and useful default buttons used for chart interaction.
        Buttons like to navigate back, set the chart on full screen and others. */
        localization?: PieChartSettingsLocalization;
        /** Settings to specify initial pie and visible slice offset once the page loaded.. */
        navigation?: {
            /** Initial pie drilldown to show. For example ['', 'Firefox', 'Firefox 2.5'] denotes to various browsers grouped by versions.  */
            initialDrilldown?: Array<string>;
            /** Initial offset, number of items from start. */
            initialOffset?: number;
            initialSelection?: Array<any>;
        };
        /** Parent chart to place this chart as subchart.
        Use area.left, area.top, area.width, area.height to position the subchart within parent chart. */
        parentChart?: BaseApi;
        /** Data values arranged in a circular manner. */
        pie?: {
            /** Whether to adapt pie outer radius dynamically to allow enough space for labels.  */
            adaptiveRadius?: boolean;
            /** Hovered pie background style.  */
            backgroundHoveredStyle?: PieChartSettingsPieStyle;
            /** Pie background style.  */
            backgroundStyle?: PieChartSettingsPieStyle;
            /** Pie center margin. */
            centerMargin?: number;
            /** Pie depth - used for raised theme. */
            depth?: number;
            /** End angle of the pie. */
            endAngle?: number;
            /** Pie inner radius. Inner pies are drawn inside this radius. If the value is less than 1, it is multiplied
            by current pie radius to get inner radius. Otherwise it represents the inner radius in pixels. */
            innerRadius?: number;
            /** Inner radius is extended to radius * innerRadiusWhenDrilldown when drilled down. */
            innerRadiusWhenDrilldown?: number;
            /** Pie margin. */
            margin?: number;
            /** Pie style when no data is present.  */
            noDataStyle?: PieChartSettingsPieStyle;
            /** Pie outer margin. */
            outerMargin?: number;
            /** Pie outer radius. If not specified, the radius is determined automatically. */
            radius?: number;
            /** Whether to show inner pies on chart.  */
            showInnerPies?: boolean;
            /** Whether to show inner pies on exported image.  */
            showInnerPiesExport?: boolean;
            /** Start angle of the pie. */
            startAngle?: number;
            /** Default pie rendering style.  */
            style?: PieChartSettingsPieStyle;
            /** Dynamically determine pie style from data.  */
            styleFunction?: (
                /** pie to apply predefined style */
                pie: any, 
                /** data relevant to pie */
                pieData: any) => void;
            /** Default pie rendering theme. See see::examples/style/themes.html::themes:: for some examples. */
            theme?: string;
            /** Center X coordinate of the pie chart.
            If the value is 'null' - coordinate is calculated automatically.
            If the value is >1 - it specifies the exact x value in pixels.
            If the value is <=1 - it specifies a fraction of chart width. */
            x?: number;
            /** Center Y coordinate of the pie chart.
            If the value is 'null' - coordinate is calculated automatically.
            If the value is >1 - it specifies the exact x value in pixels.
            If the value is <=1 - it specifies a fraction of chart height. */
            y?: number;
        };
        /** Base unit inside the circle. */
        slice?: {
            /** Style to active slices in background (back navigation) pies  */
            backgroundActiveStyle?: {
                brightness?: number;
            };
            /** Slice style on background (back navigation) pies.  */
            backgroundStyle?: {
                fillColor?: string;
                /** Extra property to alternate fill colors on backgrond slices. */
                fillColor2?: string;
            };
            /** Label connector line style.  */
            connectorStyle?: BaseSettingsLineStyle;
            /** Expandable slice mark line style  */
            expandableMarkStyle?: {
                distance?: number;
                lineColor?: string;
                lineDash?: any;
                lineWidth?: number;
            };
            /** Hovered slices style.  */
            hoverStyle?: PieChartSettingsSliceStyle;
            /** Inside labels style.  */
            insideLabelStyle?: BaseSettingsLabelStyle;
            /** Outside labels style.  */
            labelStyle?: BaseSettingsLabelStyle;
            /** Slice margin. */
            margin?: number;
            /** Controls minimal visual size of slice. Use this to make very small sizes visually bigger. The value represents 
            smallest fraction of a full pie a slice will take. The range is between 0 and 1. For example using 0.05, all slices
            smaller than 5% will be grown up to 5%. Other slices will be made proportionally smaller to accommodate for extra 
            size of small slices. */
            minFraction?: number;
            /** Style for others slice.  */
            othersStyle?: {
                fillColor?: string;
                /** Circumference decoration of 'others' slice. */
                lineDecoration?: string;
            };
            /** 'previous' slice  style.  */
            previousStyle?: {
                fillColor?: string;
                /** Circumference decoration of 'previous' slice. */
                lineDecoration?: string;
            };
            /** Selected slices style.  */
            selectedStyle?: PieChartSettingsSliceStyle;
            /** Slice style settings  */
            style?: PieChartSettingsSliceStyle;
            /** Dynamically determine slice style from data.  */
            styleFunction?: (
                /** slice to apply predefined style */
                slice: any, 
                /** slice data including subvalues */
                sliceData: any) => void;
        };
        /** Theme to apply. Should contain an javascript object with additional settings.  */
        theme?: PieChartSettings;
        /** The chart's main title. */
        title?: BaseSettingsTitle;
        /** Adjustable settings to manage default and custom toolbar items, as well as toolbar overall appearance. */
        toolbar?: BaseSettingsToolbar;
    }
    export interface PieChartSettingsAdvanced {
        /** List of assets to load from assets directory. This should be used to load CSS files. */
        assets?: Array<string>;
        /** Controls visibility of the back icon at the center of pie chart. If true, the back button is always visible, otherwise only on hover.  */
        backAlwaysVisible?: boolean;
        /** Image to display for back navigation. */
        backImage?: string;
        builtinAssets?: Dictionary<string>;
        /** URL for export proxy requests. */
        exportProxyURL?: string;
        /** Enables high resolution rendering on high DPI screens. As performance is varied across different browsers, disable this to
        improve the performance of your application.  */
        highDPI?: boolean;
        iconMinSize?: number;
        /** Enables/disables initial zoom-in animation.  */
        initialAnimation?: boolean;
        /** Whether to store entire label into bitmap. Use it to improve the performance of your application.  */
        labelCache?: boolean;
        /** Inside labels are not rendered if there is not enough space. So if available space is less than label size * treshold. */
        labelInsideTreshold?: number;
        /** Whether to show verbose logging.  */
        logging?: boolean;
        /** Maximum height of canvas object. The canvas will be stretched if chart is bigger that this. Note that increasing beyond 2048
        is known to cause loss of hardware acceleration on Safari/OSX. */
        maxCanvasHeight?: number;
        /** Maximum width of canvas object. The canvas will be stretched if chart is bigger that this. Note that increasing beyond 2048
        is known to cause loss of hardware acceleration on Safari/OSX. */
        maxCanvasWidth?: number;
        /** Extra assets to be loaded for pdfExport action. */
        pdfExportAssets?: Array<string>;
        /** Pointer related settings. */
        pointer?: BaseSettingsAdvancedPointer;
        /** Chart rendering quality. Note that it affects render performance for raised and gradient themes. Range 0 .. 1. */
        renderQuality?: number;
        /** Whether to show frames per second on the chart.  */
        showFPS?: boolean;
        /** Whether to show the current timestamp on the chart. Use only for debugging.  */
        showTimestamp?: boolean;
        /** Whether to use debugging option to paint pointer trails on screen.  */
        showTouches?: boolean;
        /** Miscellaneous style settings.  */
        style?: BaseSettingsAdvancedStyle;
        /** CSS class for current theme. Used to reference chart container in CSS files.  */
        themeCSSClass?: string;
        /** Whether to use requestAnimationFrame for requested paint instead of setTimeout.  */
        useAnimationFrame?: boolean;
    }
    export interface PieChartSettingsData {
        /** An array of fields for auto-categorization. For each field a new drilldown sub-level will be created, separated by the values of that field.  */
        autoCategories?: Array<(string|((obj: PieChartDataObject) => string))>;
        /** Load more chart data. */
        dataFunction?: (
            /** pie id */
            id: string, 
            /** max number of slices to load on pie */
            limit: number, 
            /** number of slices to skip from start */
            offset: number, 
            /** callback function to execute when data arrived correctly */
            success: (data: PieChartDataObjectRoot) => void, 
            /** callback function to execute when error occure while loading data */
            fail: (result: BaseDataErrorResponse) => void) => void;
        /** Data loading format. Currently only JSON supported. */
        format?: string;
        /** Data id used for series to reference specific data source.  */
        id?: string;
        /** Number of slices to request from server. */
        itemsToLoad?: number;
        /** Max number of parallel data requests to issue. More requests will result in faster loading, but might put heavy load on server. */
        numberOfParallelRequests?: number;
        /** Enables/Disables partial load. Items will be loaded on demand but is not compatible with sortField or autoCategories.  */
        partialLoad?: boolean;
        /** Delegate that can be used to process data returned by the server for the HTTP request issued by the chart. */
        postprocessorFunction?: (
            /** The raw data received from the server.  */
            data: any) => any;
        /** Provides the ability to embed chart data directly into the chart configuration.
        Data can be represented by an JavaScript object or a JSON string.  */
        preloaded?: (string|PieChartDataObject);
        /** Timeout in milliseconds for data requests. This timeout only applies to HTTP requests issued by the chart directly. */
        requestTimeout?: number;
        /** If set, items will be sorted in descending order using values from this field.  */
        sortField?: string;
        /** URL to load more data. URL parameters: from, to, unit */
        url?: string;
        /** List of extra parameters to pass with data URL.  */
        urlParameters?: Array<{
                /** Parameter name. */
                name?: string;
                /** Parameter value. */
                value?: string;
            }>;
    }
    export interface PieChartSettingsEvents {
        /** Time to wait after last action before firing onChartUpdate event. */
        chartUpdateDelay?: number;
        /** Function called when chart scrolling animation is finished.  */
        onAnimationDone?: (
            /** Event object attached to event listener */
            event: any) => void;
        /** Function called when whenever current view has changed. Usually after panning and navigation. Use to update any linked views.
        Note that this is also fired after chart initialization and API methods. Use event.origin field to determine event's origin.  */
        onChartUpdate?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when user clicks on chart.  */
        onClick?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when user double clicks on chart.  */
        onDoubleClick?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when error occurs, default behavior is log to console.  */
        onError?: (
            /** error message  */
            message: any) => void;
        /** Function called when object pointer is on changes.  */
        onHoverChange?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** 
        @deprecated Use onChartUpdate instead */
        onPieChange?: () => void;
        /** 
        @deprecated Use onChartUpdate instead */
        onPieReadyStateChanged?: () => void;
        /** Function called whenever chart placement on screen changes. Note that this is called on every animation frame and is intended
        for painting overlays only.  */
        onPositionChange?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when user right clicks on chart.  */
        onRightClick?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when selected slices has changed.  */
        onSelectionChange?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when settings are changed.  */
        onSettingsChange?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when user triple clicks on chart. Use it for custom function call.  */
        onTripleClick?: (
            /** Event object attached to event listener  */
            event: any) => void;
    }
    export interface PieChartSettingsInteraction {
        /** Chart animation settings. */
        animation?: {
            /** Duration of hover animation. */
            hoverDuration?: number;
            /** Duration of scroll animation. */
            scrollDuration?: number;
        };
        /** If true, empty donut center area reacts to clicks. */
        coverCenter?: boolean;
        /** Interaction mode */
        mode?: string;
        /** Slice including all the values that can not be displayed as a separate slice. Use them to configure 'others' slice rendering space. */
        others?: {
            /** If true, when offset > 0 click on center acts as click on previous slice.  */
            centerGoesToPrevious?: boolean;
            /** Enable/Disable Others/Previous slices.  */
            enabled?: boolean;
            /** Max size of others slice, as a fraction of 1. If others slice is bigger than this, it will be made smaller and other slices proportionally expanded. */
            maxOthersFraction?: number;
            /** Max number of slices to show. All remaining slices will be replaced by 'Others' slice. */
            maxSlicesVisible?: number;
            /** Minimum slice size as fraction of full pie. All slices smaller than that are replaced with 'Others' slice. */
            minSliceFraction?: number;
            /** Others and Previous slice size as fraction of full pie.
            Previous will always be this big.
            Other will be at least this big but no bigger than maxOthersFraction. */
            navigationFraction?: number;
        };
        resizing?: BaseSettingsResizer;
        /** One of interactivity option to scroll among data. */
        scrolling?: {
            /** Enable/disable scrolling the Other/Previous slices by rotating the chart.  */
            enabled?: boolean;
        };
        /** One of interactivity option to use the data selection. */
        selection?: {
            /** Enable/disable selection.  */
            enabled?: boolean;
            /** Max cutout distance on swipe. */
            maxSwipeDistance?: number;
            /** Wether to select slice by swipe. Note that it works independently of selection mode. */
            swipe?: boolean;
            /** Selection distance tolerance. */
            tolerance?: number;
        };
    }
    export interface PieChartSettingsLegend {
        /** Settings to configure the legend marker appearance if disabled series corresponded. */
        advanced?: {
            /** Style for legend entry in case when disabled series presented.  */
            disabledSeries?: {
                fillColor?: string;
                lineColor?: string;
                textColor?: string;
            };
            /** Background color for selected legend entry. */
            selectedBackground?: string;
            /** Border color for selected legend entry. */
            selectedBorder?: string;
        };
        /** Show/hide chart legend.  */
        enabled?: boolean;
        /** Whether to order entries to get possibly equal number of items into columns or rows. If false, once the row or column is full of entries,
        the next element will be first in the new row or column/rows.  */
        equalizeRowsColumns?: boolean;
        /** Maximum height of the legend. If null, all available vertical space of chart will be consumed to set as much entries as possible.
        It coincides with the chart height if legend panel side is on a left or right. */
        height?: number;
        /** Vertical space between the lines of text. */
        lineSpacing?: number;
        /** Margin around each legend entry. */
        margin?: number;
        /** Visual element of legend entry with appropriate style to a slice color it corresponds. 
        The content of each legend marker is the same as info popup appearing while hovering on slice.  */
        marker?: PieChartSettingsLegendMarker;
        /** Max number of symbols used in one line of text that applies to any legend entry. */
        maxLineSymbols?: number;
        /** Max number of columns. Use in conjunction with side parameter under the legend panel should be right or left in order to arrange entries by columns. */
        numberOfColumns?: number;
        /** Max number of rows. Use in conjunction with side parameter under the legend panel that should be set as bottom or top in order to arrange entries by rows. */
        numberOfRows?: number;
        /** Padding around each entry text and marker. */
        padding?: number;
        /** Legend enclosing panel settings.  */
        panel?: BaseSettingsLegendPanel;
        /** Text settings displaying in legend entries.  */
        text?: {
            fillColor?: string;
            font?: string;
        };
        /** Maximum width of the legend. If null, all available horizontal space of chart will be consumed to set as much entries as possible.
        It coincides with the chart width if legend panel side is on a top or bottom. */
        width?: number;
    }
    export interface PieChartSettingsLegendMarker {
        /** Marker position relative to text */
        alignment?: string;
        /** Line color around marker shape */
        lineColor?: string;
        /** Entry marker shape. */
        shape?: string;
        /** Marker size. */
        size?: number;
    }
    export interface PieChartSettingsLocalization {
        /** Text used on menu close button.  */
        closeButton?: string;
        /** Error message when data request has failed.  */
        dataRequestFailed?: string;
        /** Message to show when data loading is in progress.  */
        loadingLabel?: string;
        othersLabel?: string;
        previousLabel?: string;
        /** Strings used in toolbars.  */
        toolbar?: BaseSettingsLocalizationToolbar;
    }
    export interface PieChartSettingsPieStyle {
        background?: boolean;
        /** Pie background brightness. */
        brightness?: number;
        /** Color distribution among slices. */
        colorDistribution?: string;
        /** Pie background fill color. Useful while pie slices are loading. */
        fillColor?: string;
        /** Color set for pie slices. */
        sliceColors?: Array<string>;
    }
    export interface PieChartSettingsSliceStyle {
        /** Brightness applied to slice line and fill color
        value 0 - black
        value 1 - unchanged
        value 2 - transparent  */
        brightness?: number;
        /** Distance how far the slice is moved away from pie. */
        cutoutDistance?: number;
        /** Slice fill color. */
        fillColor?: string;
        /** Icon to display on slice. */
        icon?: string;
        /** Text style inside the slice  */
        insideLabel?: BaseSettingsLabelStyle;
        /** Text style outside of pie.  */
        label?: BaseSettingsLabelStyle;
        /** Brightness applied to slice line color */
        lineBrightness?: number;
        /** Outline color. */
        lineColor?: string;
        /** Line dash array that is a pattern to get a dashed line. The array contains length of dash followed by length of space. 
        Note that a sequence of multiple dash-space values is supported. */
        lineDash?: Array<number>;
        /** Width of the slice outline. */
        lineWidth?: number;
        /** Url to open on click. */
        url?: string;
    }
    export interface PieChartSlice {
        active: boolean;
        brightness: number;
        currentCutoutDistance: any;
        currentFillColor: any;
        currentFraction: number;
        currentIcon: any;
        currentInsideLabel: any;
        currentLabel: BaseLabel;
        currentLineColor: any;
        cutoutDistance: number;
        data: any;
        /** Whether to expand the slice as a default click behavior.  */
        expandable: boolean;
        fillColor: string;
        fillColor2: string;
        fraction: number;
        icon: any;
        iconOffset: any;
        id: string;
        index: number;
        inside: boolean;
        insideLabel: string;
        insideLabelStyle: BaseSettingsLabelStyle;
        label: string;
        labelStyle: BaseSettingsLabelStyle;
        lineBrightness: number;
        lineColor: string;
        lineDash: Array<number>;
        lineDecoration: string;
        lineWidth: number;
        percent: number;
        pie: PieChartPie;
        removed: boolean;
        selectDistance: number;
        selected: boolean;
        targetFillColor: string;
        targetLineColor: string;
        url: string;
        userPlaced: boolean;
        value: number;
        x: number;
        y: number;
    }
    export interface TimeChartDataObject {
        /** 
        @deprecated Use `values` instead. */
        data?: Array<Array<number>>;
        dataLimitFrom?: number;
        dataLimitTo?: number;
        error?: string;
        from: number;
        to: number;
        unit: string;
        /** The list of values for the chart. Each array represents values for a single point in time. The first (index 0) value must
        contain the timestamp value, the rest are values for individual series.
        For example: [[time1, series1_Val1, series2_Val1], [time2, series1_Val2, series2_Val2]]  */
        values: Array<Array<number>>;
    }
    export interface TimeChartSettings {
        advanced?: TimeChartSettingsAdvanced;
        /** Chart area related settings. */
        area?: TimeChartSettingsArea;
        assetsUrlBase?: string;
        /** Default series settings for each series rendering type. Use this to configure all series of specific type to get line or column chart or combination of them. */
        chartTypes?: {
            /** Series type to show an opening and closing value on top of a total variance. */
            candlestick?: LinearChartSettingsSeriesCandleStick;
            /** Series type to render values as vertical bars. */
            columns?: LinearChartSettingsSeriesColumns;
            /** Series type to connect value points by lines. */
            line?: LinearChartSettingsSeriesLines;
        };
        /** Element of the page where the chart will be inserted. For example a div. Any contents of the element will be cleared.
        Note that a single element can host only one chart.  */
        container?: (string|HTMLElement);
        credits?: BaseSettingsCredits;
        /** Moving time line that represents the current time, mainly to analyze real-time data changes. To achieve it,
        use server time of page load and adjust time zone offset. */
        currentTime?: TimeChartSettingsCurrentTime;
        data?: Array<TimeChartSettingsData>;
        /** The events used to handle user interaction with UI elements. See see::interactivity/::events:: for more info. */
        events?: TimeChartSettingsEvents;
        /** Info popup when hovering over columns or lines. Content returned in a form of html and is relevant to context of series hovered. */
        info?: LinearChartSettingsInfoPopup;
        /** A variety of interaction options that includes scrolling, zooming and swipe. */
        interaction?: TimeChartSettingsInteraction;
        legend?: LinearChartSettingsLegend;
        /** Localizeable strings including export type options and useful default buttons used for chart interaction.
        Buttons like to navigate back, set the chart on full screen and others. */
        localization?: TimeChartSettingsLocalization;
        /** Settings to specify initial view once the page loaded. */
        navigation?: {
            /** Whether to allow the chart view to follow display anchor. Use it for real-time updates.  */
            followAnchor?: boolean;
            /** Specifies anchor position for initial time period. Use it together with initialDisplayPeriod from which beginning is calculated. */
            initialDisplayAnchor?: string;
            /** Time period to show initially. Use in combination with intitialDisplayAnchor.
            Range displayed on time axis according to local or specified time-zone offset. */
            initialDisplayPeriod?: string;
            /** Data display unit to use for initial view. */
            initialDisplayUnit?: string;
        };
        /** Parent chart to place this chart as subchart.
        Use area.left, area.top, area.width, area.height to position the subchart within parent chart. */
        parentChart?: BaseApi;
        /** Array of series in the chart. Each of the series can be different type, can use different data source and
        aggregation. Additionally, series can be clustered and stacked. */
        series?: Array<LinearChartSettingsSeries>;
        /** The default series used as the chart dominant data. Use settings.series array to specify actual series. */
        seriesDefault?: LinearChartSettingsSeries;
        /** Defines stack settings to use in series. Each property is a stack name and value is stack settings.
        Values stack of each series on top of each other in the specified series order. Those, stacked bars help
        to visualize data that is a sum of parts, each of which is in a series.  */
        stacks?: Dictionary<LinearChartSettingsStack>;
        /** Theme to apply. Should contain an javascript object with additional settings.  */
        theme?: TimeChartSettings;
        timeAxis?: TimeChartSettingsTimeAxis;
        /** The chart's main title. */
        title?: BaseSettingsTitle;
        /** Adjustable settings to manage default and custom toolbar items, as well as toolbar overall appearance. */
        toolbar?: TimeChartSettingsToolbar;
        /** Map from name to configuration. Currently supported are default and secondary. Default value axis is located on the left hand side of the chart and 
        secondary is located on the right hand side. Both can be configured to be either inside or outside the chart.  */
        valueAxis?: Dictionary<LinearChartSettingsValueAxis>;
        valueAxisDefault?: LinearChartSettingsValueAxis;
    }
    export interface TimeChartSettingsAdvanced {
        /** List of assets to load from assets directory. This should be used to load CSS files. */
        assets?: Array<string>;
        builtinAssets?: Dictionary<string>;
        /** Determines how frequently to poll for new data. If set to null data polling is disabled. */
        dataUpdateInterval?: number;
        /** URL for export proxy requests. */
        exportProxyURL?: string;
        /** Enables high resolution rendering on high DPI screens. As performance is varied across different browsers, disable this to
        improve the performance of your application.  */
        highDPI?: boolean;
        /** Whether to store entire label into bitmap. Use it to improve the performance of your application.  */
        labelCache?: boolean;
        /** Whether to show verbose logging.  */
        logging?: boolean;
        /** Maximum height of canvas object. The canvas will be stretched if chart is bigger that this. Note that increasing beyond 2048
        is known to cause loss of hardware acceleration on Safari/OSX. */
        maxCanvasHeight?: number;
        /** Maximum width of canvas object. The canvas will be stretched if chart is bigger that this. Note that increasing beyond 2048
        is known to cause loss of hardware acceleration on Safari/OSX. */
        maxCanvasWidth?: number;
        /** Maximum data points to render in one view. Note that TimeChart will not allow to select such time unit that will result in more points being rendered. */
        maxUnitsToDisplay?: number;
        /** Extra assets to be loaded for pdfExport action. */
        pdfExportAssets?: Array<string>;
        /** Pointer related settings. */
        pointer?: BaseSettingsAdvancedPointer;
        /** Whether to show frames per second on the chart.  */
        showFPS?: boolean;
        /** Whether to show the current timestamp on the chart. Use only for debugging.  */
        showTimestamp?: boolean;
        /** Whether to use debugging option to paint pointer trails on screen.  */
        showTouches?: boolean;
        /** Miscellaneous style settings.  */
        style?: BaseSettingsAdvancedStyle;
        /** CSS class for current theme. Used to reference chart container in CSS files.  */
        themeCSSClass?: string;
        /** Time interval in which current time marker is updated, in ms. */
        timeUpdateInterval?: number;
        /** Whether to use requestAnimationFrame for requested paint instead of setTimeout.  */
        useAnimationFrame?: boolean;
    }
    export interface TimeChartSettingsArea {
        /** List of display periods to show in time axis and snap the chart to.  */
        displayPeriods?: Array<TimeChartSettingsAreaDisplayPeriod>;
        /** List of time units to use for data aggregation.  */
        displayUnits?: Array<{
                /** Used units */
                unit?: string;
                /** Name of used units */
                name?: string;
            }>;
        /** Height of the chart. If undefined the chart height will adapt to container element. */
        height?: number;
        left?: number;
        /** The maximum chart height. Chart will not resize below this. */
        maxHeight?: number;
        /** The maximum chart width. The chart will not resize below this */
        maxWidth?: number;
        /** The minimum chart height. Chart will not resize below this. */
        minHeight?: number;
        /** The minimum chart width. The chart will not resize below this */
        minWidth?: number;
        noData?: boolean;
        /** Area style settings.  */
        style?: TimeChartSettingsAreaStyle;
        top?: number;
        /** Width of the chart. If undefined the chart width will adapt to container element. */
        width?: number;
    }
    export interface TimeChartSettingsAreaDisplayPeriod {
        /** Reference time for passed data.  */
        displayAnchor?: string;
        /** Display period.  */
        displayPeriod?: string;
        /** Units in which to show data. */
        displayUnit?: string;
        /** Named time interval.  */
        name?: string;
    }
    export interface TimeChartSettingsAreaStyle {
        /** Background fill color of chart area */
        fillColor?: string;
        /** Background image of  chart area. */
        image?: string;
        /** Style for the spinning 'Loading data' indicator  */
        loadingData?: {
            fillColor?: string;
        };
        /** Text style for all markers.  */
        markerText?: BaseSettingsTextStyle;
        /** Style settings when there is no data to display.  */
        noData?: {
            fillColor?: string;
            /** Image to show when there is no data to display. */
            image?: string;
        };
        overlayColor?: string;
        /** Time period selection style.  */
        selection?: {
            fillColor?: string;
            lineColor?: string;
            lineWidth?: number;
        };
        /** Time period selection text style.  */
        selectionLabel?: BaseSettingsTextStyle;
        /** Zoom In/Zoom Out animation highlight settings.  */
        zoomHighlight?: {
            /** Cross fade in duration. */
            fadeCross?: number;
            /** Fade in duration. */
            fadeIn?: number;
            /** Fade in duration. */
            fadeOut?: number;
            fillColor?: string;
        };
        /** Zoom highlight style after zoom animation is finished.  */
        zoomHighlightInactive?: {
            fillColor?: string;
        };
    }
    export interface TimeChartSettingsCurrentTime {
        /** Show/hide current time updater.  */
        enabled?: boolean;
        label?: string;
        /** Moving time line that represents the current time, mainly to analyze real-time data changes.
        To achieve it, use server time of page load and adjust time zone offset.
        Timestamp should be UTC in milliseconds. */
        overrideCurTime?: number;
        /** Time updater style.  */
        style?: BaseSettingsBackgroundStyle;
    }
    export interface TimeChartSettingsData {
        /** Maximum number of data entries to store per data unit. */
        cacheSize?: number;
        /** Load more chart data.  */
        dataFunction?: (
            /** timestamp from which data to be loaded */
            from: number, 
            /** timestamp from which data to be loaded */
            to: number, 
            /** time steps at what data can be fetched */
            unit: string, 
            /** callback function to execute when data arrived correctly */
            success: (data: TimeChartDataObject) => void, 
            /** callback function to execute when error occure while loading data */
            fail: (result: BaseDataErrorResponse) => void) => void;
        /** Data loading format. Currently only JSON supported. */
        format?: string;
        /** Data id used for series to reference specific data source.  */
        id?: string;
        /** Whether to request only when scrolling/scaling has stopped.  */
        minimizeRequests?: boolean;
        /** Max number of parallel data requests to issue. More requests will result in faster loading, but might put heavy load on server. */
        numberOfParallelRequests?: number;
        /** Delegate that can be used to process data returned by the server for the HTTP request issued by the chart. */
        postprocessorFunction?: (
            /** The raw data received from the server.  */
            data: any) => any;
        /** How much data to load in advance. For example, ratio * chart width worth of data is loaded in both directions. */
        prefetchRatio?: number;
        /** Provides the ability to embed chart data directly into the chart configuration.
        Data can be represented by an JavaScript object or a JSON string.  */
        preloaded?: TimeChartDataObject;
        /** Maximum number of data points to request in one go. Multiple requests will be issued if more data is needed. */
        requestMaxUnits?: number;
        /** Timeout in milliseconds for data requests. This timeout only applies to HTTP requests issued by the chart directly. */
        requestTimeout?: number;
        /** Data time zone offset in minutes. */
        timeZoneOffset?: (string|number);
        /** Whether to use timestamp in seconds instead of milliseconds.  */
        timestampInSeconds?: boolean;
        /** Time steps at what data can be fetched.  */
        units?: Array<string>;
        /** URL to load more data. URL parameters: from, to, unit */
        url?: string;
        /** Different urls by data units. Specify specific URL for each time unit. For example, specify data file where
        time aggregated by years - urlByUnit:{ 'y':'/data/yearData.json}  */
        urlByUnit?: {
            /** URL for data for each month  */
            M?: string;
            /** URL for data for each day  */
            d?: string;
            /** URL for data for each hour  */
            h?: string;
            /** URL for data for each minute  */
            m?: string;
            /** URL for data for each millisecond  */
            ms?: string;
            /** URL for data for each second  */
            s?: string;
            /** URL for data for each year  */
            y?: string;
        };
        /** List of extra parameters to pass with data URL.  */
        urlParameters?: Array<{
                /** Parameter name. */
                name?: string;
                /** Parameter value. */
                value?: string;
            }>;
    }
    export interface TimeChartSettingsEvents {
        /** Time to wait after last action before firing onChartUpdate event. */
        chartUpdateDelay?: number;
        /** Function called when chart scrolling animation is finished.  */
        onAnimationDone?: (
            /** Event object attached to event listener */
            event: any) => void;
        /** Function called when whenever current view has changed. Usually after panning and navigation. Use to update any linked views.
        Note that this is also fired after chart initialization and API methods. Use event.origin field to determine event's origin.  */
        onChartUpdate?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when user clicks on chart.  */
        onClick?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when user double clicks on chart.  */
        onDoubleClick?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when error occurs, default behavior is log to console.  */
        onError?: (
            /** error message  */
            message: any) => void;
        /** Function called when object pointer is on changes.  */
        onHoverChange?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called whenever chart placement on screen changes. Note that this is called on every animation frame and is intended
        for painting overlays only.  */
        onPositionChange?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when user right clicks on chart.  */
        onRightClick?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when selected slices has changed.  */
        onSelectionChange?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** Function called when settings are changed.  */
        onSettingsChange?: (
            /** Event object attached to event listener  */
            event: any) => void;
        /** 
        @deprecated same as onChartUpdate */
        onTimeChange?: () => void;
        /** Function called when user triple clicks on chart. Use it for custom function call.  */
        onTripleClick?: (
            /** Event object attached to event listener  */
            event: any) => void;
    }
    export interface TimeChartSettingsInteraction {
        /** Chart animation settings. */
        animation?: {
            /** Duration of hover animation. */
            hoverDuration?: number;
            /** Duration of scroll animation. */
            scrollDuration?: number;
        };
        resizing?: BaseSettingsResizer;
        /** Scrolling settings. */
        scrolling?: TimeChartSettingsInteractionScrolling;
        /** Configurable settings to select specific time period. */
        selection?: TimeChartSettingsInteractionSelection;
        /** Snap mode determines how the chart locks on to data periods after dragging, scrolling and other actions. */
        snapMode?: string;
        /** Sensitivity of Left/Right/Up/Down swipes. */
        swipeSensitivity?: number;
        /** Configurable settings to enhance and alleviate zoom interaction. */
        zooming?: {
            /** Enable/Disable zooming options.  */
            enabled?: boolean;
            /** Whether to zoom by two finger pinch.  */
            fingers?: boolean;
            /** Max zoom difference when using pinch gesture. */
            fingersMaxZoom?: number;
            /** Chart is zoomed in or out by this factor when pressing Up or Down keys. */
            keyboardFactor?: number;
            /** Mouse zooming sensitivity. Note that bigger values correspond to faster zooming. */
            sensitivity?: number;
            /** Whether to zoom by swiping up or down.  */
            swipe?: boolean;
            /** How far pointer must be moved up or down in pixels before zooming activates. */
            upDownTreshold?: number;
            /** Whether to zoom by mouse wheel.  */
            wheel?: boolean;
            /** Zoomed area is highlighted if zoom is changed more number of times than this. */
            zoomHighlightThreshold?: number;
        };
    }
    export interface TimeChartSettingsInteractionScrolling {
        /** Enables/Disables scrolling.  */
        enabled?: boolean;
        /** How far to scroll when Left or Right keys are pressed. Multiples of chart width. */
        keyboardScrollingFactor?: number;
        /** Scrolling friction coefficient (chartWidth/ms^2). */
        kineticFriction?: number;
        /** Limits scrolling in the left side. This should be either the timestamp value in milliseconds or the string constant 'oldestData'.
        Specify `null` to disable the limit.  */
        limitFrom?: (string|number);
        /** Scrolling limit mode. The actual limits are stored in limitFrom and limitTo. */
        limitMode?: string;
        /** Limits scrolling in the right side. This should be either the timestamp value in milliseconds or the string constant 'newestData'.
        Specify `null` to disable the limit.  */
        limitTo?: (string|number);
        overscrollProportion?: number;
        /** Whether to use scrolling by full page instead of kinetic scrolling.  */
        swipePageFlipping?: boolean;
    }
    export interface TimeChartSettingsInteractionSelection {
        /** Enable/disable selection  */
        enabled?: boolean;
        /** Distance from selected object sides to move it. */
        tolerance?: number;
    }
    export interface TimeChartSettingsLocalization {
        /** Calendar specific localization settings. This section is used to initialize moment.js locale.
        See moment.js documentation for detailed description: http://momentjs.com/docs/#/customization/ .  */
        calendar?: {
            months?: Array<string>;
            monthsShort?: Array<string>;
            week?: {
                dow?: number;
                doy?: number;
            };
            weekdays?: Array<string>;
            weekdaysMin?: Array<string>;
            weekdaysShort?: Array<string>;
        };
        /** Text used on menu close button.  */
        closeButton?: string;
        /** Error message when data request has failed.  */
        dataRequestFailed?: string;
        /** Message being displayed while loading initial data.  */
        determiningDataBounds?: string;
        /** Weekdays that are considered holidays. Uses ISO numbering, with 1 being Monday and 7 being Sunday. */
        holidayWeekdays?: Array<number>;
        /** Localizable strings displayed in info popup. */
        infoDates?: {
            /** Time formatting strings to display full time for given time unit.  */
            fullTimeFormats?: TimeChartSettingsLocalizationTimeUnits;
            /** Time formatting strings for time marker date.  */
            majorTimeFormats?: TimeChartSettingsLocalizationTimeUnits;
            /** Time formatting strings for info popup time display.  */
            minorTimeFormats?: TimeChartSettingsLocalizationTimeUnits;
        };
        /** Message to show when data loading is in progress.  */
        loadingLabel?: string;
        /** Localizable strings for markers. */
        markerDates?: {
            /** Time formatting strings for time marker date.  */
            timeFormats?: TimeChartSettingsLocalizationTimeUnits;
        };
        /** Text to show when there is no data to display.  */
        noDataLabel?: string;
        /** Localizable strings displayed in time axis. */
        timeAxisDates?: {
            /** Time formatting strings for major time units in bottom line of time axis.  */
            majorLabelFullTimeFormats?: TimeChartSettingsLocalizationTimeUnits;
            /** Time formatting strings for major time units in bottom line of time axis.  */
            majorLabelTimeFormats?: TimeChartSettingsLocalizationTimeUnits;
            /** Time formatting strings for minor time units in top line of time axis.  */
            minorLabelTimeFormats?: TimeChartSettingsLocalizationTimeUnits;
        };
        /** Named time units.  */
        timeUnitsNames?: TimeChartSettingsLocalizationTimeUnits;
        /** Plural forms of time units.  */
        timeUnitsNamesPlural?: TimeChartSettingsLocalizationTimeUnits;
        /** Strings used in toolbars.  */
        toolbar?: TimeChartSettingsLocalizationToolbar;
        /** Map from unit prefix to multiplier. Used for value axis formatting. */
        valueUnits?: Dictionary<number>;
    }
    export interface TimeChartSettingsLocalizationTimeUnits {
        /** Months  */
        M?: string;
        d?: string;
        h?: string;
        /** Minutes  */
        m?: string;
        /** Milliseconds  */
        ms?: string;
        s?: string;
        w?: string;
        y?: string;
    }
    export interface TimeChartSettingsLocalizationToolbar {
        backButton?: string;
        backTitle?: string;
        /** Text to show in display periods drop-down when current period does not match any of the presets.  */
        customPeriod?: string;
        exportButton?: string;
        exportCSV?: string;
        exportJpeg?: string;
        exportPDF?: string;
        exportPNG?: string;
        exportTitle?: string;
        exportXLS?: string;
        fullscreenButton?: string;
        fullscreenTitle?: string;
        /** Linear mode button text.  */
        linButton?: string;
        /** Lin/Log button title.  */
        linLogTitle?: string;
        /** Logarithmic mode button text.  */
        logButton?: string;
        /** Display period dropdown title.  */
        periodDropdownTitle?: string;
        /** Display unit dropdown title.  */
        unitDropdownTitle?: string;
        /** Zoom out button text.  */
        zoomoutButton?: string;
        /** Zoom out button title.  */
        zoomoutTitle?: string;
    }
    export interface TimeChartSettingsTimeAxis {
        /** Shows/hides time axis.  */
        enabled?: boolean;
        /** Maximal width of displayed cart value, in px. If the width is bigger than this, 
        Time Chart will use a smaller time unit (e.g. switch from minutes to seconds). */
        maxUnitWidth?: number;
        /** Minimum width of a displayed value, in px . If the width is smaller than this, Time Chart will switch to bigger time units (e.g. from minutes to hours). */
        minUnitWidth?: number;
        /** Whether to show smallest bars on time axis. It matches with display unit dropdown entry used in time chart toolbar.  */
        miniTimeRuler?: boolean;
        /** Whether to show holidays in day view.  */
        showHolidays?: boolean;
        /** Time axis style  */
        style?: {
            dateHolidays?: {
                fillColor?: string;
            };
            /** Tint for lighter blocks of altering shades in time axis.  */
            dateLighten?: {
                fillColor?: string;
            };
            /** Style for major time labels balloons.  */
            majorTimeBalloonStyle?: {
                fillColor?: string;
            };
            /** Style for major time labels.  */
            majorTimeLabel?: BaseSettingsTextStyle;
            /** Style for minor time labels balloons.  */
            minorTimeBalloonStyle?: {
                fillColor?: string;
            };
            /** Style for minor time labels.  */
            minorTimeLabel?: BaseSettingsTextStyle;
            /** Minor time ruler style.  */
            minorTimeRuler?: BaseSettingsLineStyle;
            /** Whether to show balloons around major time labels.  */
            showMajorTimeBalloons?: boolean;
            /** Whether to display minor time labels as balloons instead of ruler style.  */
            showMinorTimeBalloons?: boolean;
            /** Chart vertical grid settings  */
            vgrid?: BaseSettingsLineStyle;
        };
        /** Time axis time zone offset in minutes. */
        timeZoneOffset?: (string|number);
        /** Display unit switching policy. */
        unitSizePolicy?: string;
        /** Whether to show vertical grid.  */
        vgrid?: boolean;
    }
    export interface TimeChartSettingsToolbar {
        /** Toolbar align. Note that it can be overridden for individual items using item.align. Also Use 'top' or 'bottom' 
        sides in conjunction with 'left', 'right' align or use 'left', 'right' sides with 'top', 'bottom'. */
        align?: string;
        /** Whether to show back button in toolbar.  */
        back?: boolean;
        /** CSS class name for the toolbar HTML panel.  */
        cssClass?: string;
        /** Whether to show display period dropdown.  */
        displayPeriod?: boolean;
        /** Whether to show the display unit dropdown.  */
        displayUnit?: boolean;
        /** Show/hide toolbar.  */
        enabled?: boolean;
        /** Whether to show export dropdown in toolbar.  */
        export?: boolean;
        /** A list of user defined items to show in toolbar.  */
        extraItems?: Array<(string|BaseSettingsToolbarItem)>;
        /** An array of toolbar items. Set to completely override the items in toolbar.  */
        items?: Array<BaseSettingsToolbarItem>;
        /** Toolbar location inside chart. */
        location?: string;
        logScale?: boolean;
        /** Time periods  */
        periods?: Array<TimeChartSettingsAreaDisplayPeriod>;
        /** Whether to show or hide labels next to toolbar items by default. Note that it can be overridden for individual items using item.showLabels.  */
        showLabels?: boolean;
        /** Toolbar placement side. Note that it can be overridden for individual items using item.side. */
        side?: string;
        /** Whether to show the zoom out button.  */
        zoomOut?: boolean;
    }
    /* tslint:enable */
}

declare module ZoomCharts {
    /* tslint:disable */

    export class FacetChart {
        public constructor(settings: Configuration.FacetChartSettings);
        /** Adds specific data and updates the chart.  */
        public addData(data: any, sourceId?: string): any;
        /** 
        @deprecated use settings.parentChart instead. */
        public addSubchartContainer(container: HTMLElement): void;
        public back(): Configuration.BaseApi;
        public clearHistory(): Configuration.BaseApi;
        public customize(name: any): Configuration.BaseApi;
        public expandSlice(slice: any): boolean;
        public export(type: any, dimensions: any, transparent: any): void;
        /** returns data uri string  */
        public exportGetDimensions(dimensions: any): {
                width: number;
                height: number;
                scale: number;
                chartWidth: number;
                chartHeight: number;
            };
        public exportImageAsString(type: any, dimensions: any, transparent: any): string;
        public exportImageGetDimensions(dimensions: any): {
                width: number;
                height: number;
                scale: number;
                chartWidth: number;
                chartHeight: number;
            };
        public fullscreen(isFullscreen: boolean): boolean;
        public getActiveFacet(): Configuration.FacetChartFacet;
        public getActiveFacets(): Array<Configuration.FacetChartFacet>;
        public getActiveItems(): Array<any>;
        public getPie(): Array<any>;
        public getPieOffset(): number;
        public hideMenu(): Configuration.BaseApi;
        public home(): boolean;
        public off(name: any, listener: any): boolean;
        /** Adds event listener.
        Supported event types: "timeChange", "selectionChange, "click", "doubleClick".
        Consult doc for event types in specific SDK  */
        public on(name: any, listener: any): any;
        /** Does immediate repaint. Use to sync updates between multiple charts.  */
        public paintNow(force?: boolean): Configuration.BaseApi;
        public profiler(): Configuration.BaseProfiler;
        /** Clears data cache and loads new data. The time range is preserved.  */
        public reloadData(sourceId?: string): any;
        /** Removes chart from DOM. Is automatically called when you create a new Chart with the same container.  */
        public remove(): void;
        /** Removes data and updates the chart.  */
        public removeData(data: any, sourceId?: string): void;
        /** Removes data and updates the chart.  */
        public replaceData(data: any, sourceId?: string): any;
        public replaceSeries(series: any): any;
        public restoreState(state: any, animate?: boolean): void;
        /** returns data uri string  */
        public saveAsImage(type: any, dimensions: any, transparent: any): string;
        public saveState(): string;
        public selection(selected: any): Array<any>;
        public setPie(pieId: any, offset?: number, count?: any): FacetChart;
        public typeName: string;
        public updateFilter(): FacetChart;
        /** Re-evaluate data filters on next paint. */
        public updateFilters(): void;
        /** Updates the chart settings. Only the settings that have to be changed should be passed.  */
        public updateSettings(changes: Configuration.FacetChartSettings): FacetChart;
        /** Call when the container size has been changed to update the chart.  */
        public updateSize(): Configuration.BaseApi;
        /** Re-evaluate style for all objects on next paint. */
        public updateStyle(): void;
    }
    export class GeoChart {
        public constructor(settings: Configuration.GeoChartSettings);
        /** Adds specific data and updates the chart.  */
        public addData(data: any, sourceId?: string): any;
        /** 
        @deprecated use settings.parentChart instead. */
        public addSubchartContainer(container: HTMLElement): void;
        public back(): GeoChart;
        public bounds(bounds?: Configuration.IGeoRectangle): Configuration.IGeoRectangle;
        public clearHistory(): Configuration.BaseApi;
        public collapseNode(id: any): void;
        public customize(name: any): Configuration.BaseApi;
        public expandNode(id: any): void;
        public export(type: any, dimensions: any, transparent: any): void;
        /** returns data uri string  */
        public exportGetDimensions(dimensions: any): {
                width: number;
                height: number;
                scale: number;
                chartWidth: number;
                chartHeight: number;
            };
        public exportImageAsString(type: any, dimensions: any, transparent: any): string;
        public exportImageGetDimensions(dimensions: any): {
                width: number;
                height: number;
                scale: number;
                chartWidth: number;
                chartHeight: number;
            };
        public fullscreen(isFullscreen: boolean): boolean;
        public getNode(id: string): Configuration.ItemsChartNode;
        public getNodeDimensions(node: Configuration.ItemsChartNode): {
                x: number;
                y: number;
                radius: number;
                hwidth: number;
            };
        public hideMenu(): Configuration.BaseApi;
        public hideNode(id: any): void;
        public home(): boolean;
        /** Returns the Leaflet.Map object to enable any advanced customizations. */
        public leaflet(): any;
        public off(name: any, listener: any): boolean;
        /** Adds event listener.
        Supported event types: "timeChange", "selectionChange, "click", "doubleClick".
        Consult doc for event types in specific SDK  */
        public on(name: any, listener: any): any;
        /** Does immediate repaint. Use to sync updates between multiple charts.  */
        public paintNow(force?: boolean): Configuration.BaseApi;
        public profiler(): Configuration.BaseProfiler;
        /** Clears data cache and loads new data. The time range is preserved.  */
        public reloadData(sourceId?: string): any;
        /** Removes chart from DOM. Is automatically called when you create a new Chart with the same container.  */
        public remove(): void;
        /** Removes data and updates the chart.  */
        public removeData(data: any, sourceId?: string): void;
        /** Removes data and updates the chart.  */
        public replaceData(data: any, sourceId?: string): any;
        public restoreState(state: any, animate?: boolean): void;
        /** returns data uri string  */
        public saveAsImage(type: any, dimensions: any, transparent: any): string;
        public saveState(): string;
        /** *
         Set/Get selected objects.
          */
        public selection(
            /** - array of objects identifiers to select. Do not pass this parameter if you don't want to change current selection. */
            selected: Array<string>): Array<any>;
        public showNode(id: any): void;
        public typeName: string;
        /** Re-evaluate data filters on next paint. */
        public updateFilters(): void;
        /** Updates the chart settings. Only the settings that have to be changed should be passed.  */
        public updateSettings(changes: Configuration.GeoChartSettings): GeoChart;
        /** Call when the container size has been changed to update the chart.  */
        public updateSize(): Configuration.BaseApi;
        /** Re-evaluate style for all objects on next paint. */
        public updateStyle(): void;
        public zoomIn(objects: any, animate?: boolean): any;
        public zoomLevel(newZoom?: number): number;
    }
    export class NetChart {
        public constructor(settings: Configuration.NetChartSettings);
        /** Adds specific data and updates the chart.  */
        public addData(data: any, sourceId?: string): any;
        public addFocusNode(id: (string|Configuration.ItemsChartNode), range?: number): Configuration.NetChartFocusNode;
        /** 
        @deprecated use settings.parentChart instead. */
        public addSubchartContainer(container: HTMLElement): void;
        public back(): Configuration.BaseApi;
        public clearFocus(): void;
        public clearHistory(): Configuration.BaseApi;
        public collapseNode(id: (string|Configuration.ItemsChartNode)): Configuration.NetChartFocusNode;
        public customize(name: any): Configuration.BaseApi;
        public expandNode(id: (string|Configuration.ItemsChartNode)): Configuration.NetChartFocusNode;
        public export(type: any, dimensions: any, transparent: any): void;
        public exportData(visibleOnly?: boolean, exportCoordinates?: boolean): {
                "nodes": Array<any>;
                "links": Array<any>;
            };
        /** returns data uri string  */
        public exportGetDimensions(dimensions: any): {
                width: number;
                height: number;
                scale: number;
                chartWidth: number;
                chartHeight: number;
            };
        public exportImageAsString(type: any, dimensions: any, transparent: any): string;
        public exportImageGetDimensions(dimensions: any): {
                width: number;
                height: number;
                scale: number;
                chartWidth: number;
                chartHeight: number;
            };
        public fullscreen(isFullscreen: boolean): boolean;
        public getLink(id: string): Configuration.ItemsChartLink;
        public getNode(id: string): Configuration.ItemsChartNode;
        public getNodeDimensions(node: Configuration.ItemsChartNode): {
                x: number;
                y: number;
                radius: number;
                hwidth: number;
            };
        public hideMenu(): Configuration.BaseApi;
        public hideNode(id: (string|Configuration.ItemsChartNode)): Configuration.NetChartFocusNode;
        public home(): boolean;
        public links(): Array<Configuration.ItemsChartLink>;
        public lockNode(id: (string|Configuration.ItemsChartNode), x: any, y: any): any;
        public nodes(): Array<Configuration.ItemsChartNode>;
        public off(name: any, listener: any): boolean;
        /** Adds event listener.
        Supported event types: "timeChange", "selectionChange, "click", "doubleClick".
        Consult doc for event types in specific SDK  */
        public on(name: any, listener: any): any;
        /** Does immediate repaint. Use to sync updates between multiple charts.  */
        public paintNow(force?: boolean): Configuration.BaseApi;
        public profiler(): Configuration.BaseProfiler;
        /** Clears data cache and loads new data. The time range is preserved.  */
        public reloadData(sourceId?: string): any;
        /** Removes chart from DOM. Is automatically called when you create a new Chart with the same container.  */
        public remove(): void;
        /** Removes data and updates the chart.  */
        public removeData(data: any, sourceId?: string): void;
        public removeFocusNode(id: (string|Configuration.ItemsChartNode)): Configuration.NetChartFocusNode;
        /** Removes data and updates the chart.  */
        public replaceData(data: any, sourceId?: string): any;
        public resetLayout(): void;
        public restoreState(state: any, animate?: boolean): void;
        /** returns data uri string  */
        public saveAsImage(type: any, dimensions: any, transparent: any): string;
        public saveState(): string;
        public scrollIntoView(nodes: (Array<string>|Array<Configuration.ItemsChartNode>)): void;
        public selection(selected: Array<string>): Array<any>;
        public showNode(id: (string|Configuration.ItemsChartNode)): Configuration.NetChartFocusNode;
        public typeName: string;
        public unlockNode(id: (string|Configuration.ItemsChartNode)): any;
        /** Re-evaluate data filters on next paint. */
        public updateFilters(): void;
        /** Updates the chart settings. Only the settings that have to be changed should be passed.  */
        public updateSettings(changes: Configuration.NetChartSettings): NetChart;
        /** Call when the container size has been changed to update the chart.  */
        public updateSize(): Configuration.BaseApi;
        /** Re-evaluate style for all objects on next paint. */
        public updateStyle(): void;
        public zoom(zoomValue: number): number;
        public zoomIn(objects: any, animate?: boolean): void;
    }
    export class PieChart {
        public constructor(settings: Configuration.PieChartSettings);
        /** Adds specific data and updates the chart.  */
        public addData(data: any, sourceId?: string): any;
        /** 
        @deprecated use settings.parentChart instead. */
        public addSubchartContainer(container: HTMLElement): void;
        public back(): Configuration.BaseApi;
        public clearHistory(): Configuration.BaseApi;
        public customize(name: any): Configuration.BaseApi;
        public expandSlice(slice: any): boolean;
        public export(type: any, dimensions: any, transparent: any): void;
        /** returns data uri string  */
        public exportGetDimensions(dimensions: any): {
                width: number;
                height: number;
                scale: number;
                chartWidth: number;
                chartHeight: number;
            };
        public exportImageAsString(type: any, dimensions: any, transparent: any): string;
        public exportImageGetDimensions(dimensions: any): {
                width: number;
                height: number;
                scale: number;
                chartWidth: number;
                chartHeight: number;
            };
        public fullscreen(isFullscreen: boolean): boolean;
        public getActivePie(): Configuration.PieChartPie;
        public getActivePies(): Array<Configuration.PieChartPie>;
        public getActiveSlices(): Array<any>;
        public getPie(): Array<string>;
        public getPieOffset(): number;
        public getSliceDimensions(sliceId: any, showPartial?: boolean): {
                centerX: number;
                centerY: number;
                r0: number;
                r1: number;
                a0: number;
                a1: number;
            };
        public hideMenu(): Configuration.BaseApi;
        public home(): boolean;
        public off(name: any, listener: any): boolean;
        /** Adds event listener.
        Supported event types: "timeChange", "selectionChange, "click", "doubleClick".
        Consult doc for event types in specific SDK  */
        public on(name: any, listener: any): any;
        /** Does immediate repaint. Use to sync updates between multiple charts.  */
        public paintNow(force?: boolean): Configuration.BaseApi;
        public profiler(): Configuration.BaseProfiler;
        /** Clears data cache and loads new data. The time range is preserved.  */
        public reloadData(sourceId?: string): any;
        /** Removes chart from DOM. Is automatically called when you create a new Chart with the same container.  */
        public remove(): void;
        /** Removes data and updates the chart.  */
        public removeData(data: any, sourceId?: string): void;
        /** Removes data and updates the chart.  */
        public replaceData(data: any, sourceId?: string): any;
        public restoreState(state: any, animate?: boolean): void;
        /** returns data uri string  */
        public saveAsImage(type: any, dimensions: any, transparent: any): string;
        public saveState(): string;
        public selection(selected: any): Array<Configuration.PieChartSlice>;
        public setPie(pieId: any, offset?: number): PieChart;
        public setPieOffset(offset: any): PieChart;
        public typeName: string;
        public updateFilter(): PieChart;
        /** Re-evaluate data filters on next paint. */
        public updateFilters(): void;
        /** Updates the chart settings. Only the settings that have to be changed should be passed.  */
        public updateSettings(changes: Configuration.PieChartSettings): PieChart;
        /** Call when the container size has been changed to update the chart.  */
        public updateSize(): Configuration.BaseApi;
        /** Re-evaluate style for all objects on next paint. */
        public updateStyle(): void;
    }
    export class TimeChart {
        public constructor(settings: Configuration.TimeChartSettings);
        /** Adds specific data and updates the chart.  */
        public addData(data: any, sourceId?: string): any;
        /** 
        @deprecated use settings.parentChart instead. */
        public addSubchartContainer(container: HTMLElement): void;
        public back(): Configuration.BaseApi;
        public clearHistory(): Configuration.BaseApi;
        public customize(name: any): Configuration.BaseApi;
        public displayUnit(unit: any, animate?: boolean, rescale?: boolean, rescaleCenter?: any): any;
        public export(type: any, dimensions: any, transparent: any): void;
        /** returns data uri string  */
        public exportGetDimensions(dimensions: any): {
                width: number;
                height: number;
                scale: number;
                chartWidth: number;
                chartHeight: number;
            };
        public exportImageAsString(type: any, dimensions: any, transparent: any): string;
        public exportImageGetDimensions(dimensions: any): {
                width: number;
                height: number;
                scale: number;
                chartWidth: number;
                chartHeight: number;
            };
        public exportVisibleData(): Array<Array<string>>;
        public fullscreen(isFullscreen: boolean): boolean;
        public hideMenu(): Configuration.BaseApi;
        public home(): boolean;
        public off(name: any, listener: any): boolean;
        /** Adds event listener.
        Supported event types: "timeChange", "selectionChange, "click", "doubleClick".
        Consult doc for event types in specific SDK  */
        public on(name: any, listener: any): any;
        /** Does immediate repaint. Use to sync updates between multiple charts.  */
        public paintNow(force?: boolean): Configuration.BaseApi;
        public profiler(): Configuration.BaseProfiler;
        /** Clears data cache and loads new data. The time range is preserved.  */
        public reloadData(sourceId?: string): any;
        /** Removes chart from DOM. Is automatically called when you create a new Chart with the same container.  */
        public remove(): void;
        /** Removes data and updates the chart.  */
        public removeData(data: any, sourceId?: string): void;
        /** Removes data and updates the chart.  */
        public replaceData(data: any, sourceId?: string): any;
        public replaceSeries(series: any): any;
        public restoreState(state: any, animate?: boolean): void;
        /** returns data uri string  */
        public saveAsImage(type: any, dimensions: any, transparent: any): string;
        public saveState(): string;
        public scroll(amount: any, animate?: boolean): void;
        public selection(from: number, to: number): Array<any>;
        /** Set displayed time range using period and anchor.
        See settings for possible period / anchor values.  */
        public setDisplayPeriod(period: any, anchor: any, animate: any): any;
        /** Gets or sets the  displayed time range in JavaScript timestamp (milliseconds). */
        public time(from?: number, to?: number, animate?: boolean): [number, number];
        public typeName: string;
        /** Re-evaluate data filters on next paint. */
        public updateFilters(): void;
        /** Updates the chart settings. Only the settings that have to be changed should be passed.  */
        public updateSettings(changes: Configuration.TimeChartSettings): TimeChart;
        /** Call when the container size has been changed to update the chart.  */
        public updateSize(): Configuration.BaseApi;
        /** Re-evaluate style for all objects on next paint. */
        public updateStyle(): void;
        public zoomIn(unit?: any, center?: any, animate?: boolean): any;
        public zoomOut(unit?: any, animate?: boolean): any;
    }
    /* tslint:enable */
}

declare class FacetChart extends ZoomCharts.FacetChart { }
declare class GeoChart extends ZoomCharts.GeoChart { }
declare class NetChart extends ZoomCharts.NetChart { }
declare class PieChart extends ZoomCharts.PieChart { }
declare class TimeChart extends ZoomCharts.TimeChart { }

declare module ZoomCharts {
    export interface Dictionary<TValue> {
        [key: string]: TValue;
    }

    export interface NumberDictionary<TValue> {
        [key: number]: TValue;
    }

    export interface GradientDefinition extends Array<[number, string]> {
    }

    export interface IRectangle {
        x0: number;
        y0: number;
        x1: number;
        y1: number;
    }

    export interface IGeoRectangle {
        east: number;
        west: number;
        north: number;
        south: number;
    }
}
